package com.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import com.api.entity.AuthRequest;
import com.api.entity.JwtAuthResponse;
import com.api.entity.UserInfo;
import com.api.service.JwtService;
import com.api.service.UserInfoService;

@RestController
@RequestMapping("/auth")
public class UserController {
	/**
	 * @author vikash katiyar
	 */

	@Autowired
	private UserInfoService userInfoService;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtService jwtService;

	@PostMapping("/register")
	public String register(@RequestBody UserInfo userInfo) {
		return userInfoService.addUser(userInfo);

	}

	@PostMapping("/login")
	public ResponseEntity<JwtAuthResponse> loginUser(@RequestBody AuthRequest authRequest) {
		Authentication authenticate = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword()));
		if (authenticate.isAuthenticated()) {
			String token = jwtService.generateToken(authRequest.getEmail());
			JwtAuthResponse response = new JwtAuthResponse();
			response.setToken(token);
			response.setTokenUser(authRequest.getEmail());
			return new ResponseEntity<JwtAuthResponse>(response, HttpStatus.OK);
		} else {
			throw new UsernameNotFoundException("Invalid user request");
		}
	}

	@GetMapping("/getUsers")
	public List<UserInfo> getAllUsers() {
		return userInfoService.getAllUser();
	}

}
