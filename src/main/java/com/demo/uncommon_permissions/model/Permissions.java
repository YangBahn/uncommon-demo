package com.demo.uncommon_permissions.model;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Data
@Accessors(chain = true)
@Table(name = "PERMISSIONS")
public class Permissions {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name = "permissions_id")
	private int id;
	@Column(name = "url_regex_pattern")
	private String urlRegexPattern;
}
