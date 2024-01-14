package com.api.entity;

import lombok.Data;

@Data
public class JwtAuthResponse {
	/**
	 * @author vikash katiyar
	 */

	private String token;
	private String tokenUser;
}
