package com.coda.Bean;

import java.util.List;

import org.mapstruct.factory.Mappers;

import com.coda.Entity.UserEntity;


public interface UserMapper {
	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
	UserEntity userToEntity(User user);	
	User entityToUser(UserEntity entity);
	
	List<User> userEntityListToUser(List<UserEntity> ue);
}
