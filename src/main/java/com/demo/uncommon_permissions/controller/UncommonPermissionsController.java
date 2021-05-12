package com.demo.uncommon_permissions.controller;


import com.demo.uncommon_permissions.model.Permissions;
import com.demo.uncommon_permissions.model.UserPermissions;
import com.demo.uncommon_permissions.service.PermissionsService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class UncommonPermissionsController {

	private static final Logger logger = LoggerFactory.getLogger(UncommonPermissionsController.class);
	private final PermissionsService permissionsService;

	@GetMapping("/listAll")
	public Iterable<Permissions> listAvailablePermissions() {
		return permissionsService.listAllPermissions();

	}

	@GetMapping("/listPermissions")
	public Iterable<Permissions> listUserPermissions(@RequestParam(name = "userId") Integer userId) {
		return permissionsService.findAllByUserId(userId);
	}

	@GetMapping("/isAllowed")
	public boolean isAllowed(@RequestParam(name = "userId") Integer userId, @RequestParam(name = "url") String url) {
		return permissionsService.userHasPermission(userId, url);
	}

	@PutMapping("/addAvailablePermissions")
	public Iterable<Permissions> addAvailablePermissions(@RequestParam(name = "url_regex") String urlRegex) {

		return permissionsService.addPermissions(urlRegex);
	}

	// TODO : should this SET or ADD permissions to a user? Currently Adding since the method is defined as PUT
	@PutMapping("/setPermissions")
	public Iterable<UserPermissions> setPermissionsForUser(@RequestParam(name = "url_regex") String urlRegex, @RequestParam(name = "user_id") int userId) {
		return permissionsService.addPermissionForUser(urlRegex, userId);
	}


	@DeleteMapping("/removePermissions")
	public Iterable<UserPermissions> removePermissions(@PathVariable(name = "user_id") int userId, @PathVariable(name = "permissions_id") int permissionsId) {
		return permissionsService.removeUserPermission(userId, permissionsId);
	}


}
