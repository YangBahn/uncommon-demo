package com.demo.uncommon_permissions.model;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionsRepository extends CrudRepository<Permissions, Integer> {

	@Override
	List<Permissions> findAll();




	List<Permissions> findAllByIdIn(List<Integer> permission_ids);
}
