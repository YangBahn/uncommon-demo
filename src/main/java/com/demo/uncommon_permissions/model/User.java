package com.demo.uncommon_permissions.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "USERS")
public class User {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name = "user_id")
	private int id;
}
