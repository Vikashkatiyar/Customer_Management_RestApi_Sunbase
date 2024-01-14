package com.api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {
	/**
	 * @author vikash katiyar
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotEmpty
	@Size(min = 1, message = "UserName is missing")
	private String name;

	@NotEmpty
	@Size(min = 1, message = "UserEmail is missing")
	private String email;
	private String roles;

	@NotEmpty
	@Size(min = 1, message = "UserPassword is missing")
	private String password;
}
