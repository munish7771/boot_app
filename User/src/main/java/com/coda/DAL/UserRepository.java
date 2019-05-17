package com.coda.DAL;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.coda.Entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer>{
	@Query("select u from UserEntity u where username = ?1")
	public UserEntity findUserbyUsername(String username);
	
	Optional<UserEntity> findByUsername(String username);
    public Boolean existsByUsername(String username);
//    public Boolean existsByEmail(String email);
}