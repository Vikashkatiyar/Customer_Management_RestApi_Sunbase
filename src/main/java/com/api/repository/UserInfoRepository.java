package com.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.entity.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {
	/**
	 * 
	 * @author vikash katiyar
	 * 
	 */

	Optional<UserInfo> findByEmail(String email);

}
