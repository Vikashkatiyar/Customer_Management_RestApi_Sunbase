package com.api.entity;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthRequest {
	/**
	 * @author vikash katiyar
	 */

	@NotEmpty
	private String email;

	@NotEmpty
	private String password;
}
