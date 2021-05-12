package com.demo.uncommon_permissions.model;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Data
@Accessors(chain = true)
@Table(name = "PERMISSIONS_USERS")
public class UserPermissions {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	@Column(name = "permissions_id")
	private int permissionsId;
	@Column(name = "user_id")
	private int userId;
}
