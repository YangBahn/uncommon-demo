package com.demo.uncommon_permissions.service;

import com.demo.uncommon_permissions.model.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PermissionsService {

	private final PermissionsRepository permissionsRepository;
	private final UserPermissionsRepository userPermissionsRepository;

	public List<Permissions> listAllPermissions() {
		return permissionsRepository.findAll();
	}

	@Transactional(readOnly = true)
	public List<Permissions> findAllByUserId(int userId) {
		return Optional.ofNullable(userPermissionsRepository.findAllByUserId(userId))
				.orElse(Collections.emptyList()).stream()
				.map(UserPermissions::getPermissionsId)
				.collect(Collectors.collectingAndThen(Collectors.toList(),
						permissionsRepository::findAllByIdIn
				));
	}

	@Transactional(readOnly= true)
	public boolean userHasPermission(int userId, String url) {

		return findAllByUserId(userId).stream()
				.anyMatch(permissions -> Pattern.compile(permissions.getUrlRegexPattern()).matcher(url).matches());
	}

	@Transactional
	public Iterable<Permissions> addPermissions(String url_regex) {
		return permissionsRepository.saveAll(Collections.singletonList(new Permissions().setUrlRegexPattern(url_regex)));
	}

	@Transactional
	public Iterable<UserPermissions> addPermissionForUser(String urlRegex, int userId) {
		Permissions newPermission = permissionsRepository.save(new Permissions().setUrlRegexPattern(urlRegex));
		UserPermissions newUserPermissions = new UserPermissions()
				.setPermissionsId(newPermission.getId())
				.setUserId(userId);

		return userPermissionsRepository.saveAll(Collections.singletonList(newUserPermissions));
	}

	@Transactional
	public Iterable<UserPermissions> removeUserPermission(int userId, int permissionsId) {
		return userPermissionsRepository.deleteUserPermissionsByUserIdAndPermissionsId(userId, permissionsId);
	}


}
