package com.demo.uncommon_permissions.model;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserPermissionsRepository extends CrudRepository<UserPermissions, Integer> {

	List<UserPermissions> findAllByUserId(int userId);
	List<UserPermissions> deleteUserPermissionsByUserIdAndPermissionsId(int userId, int permissionsId);
}
