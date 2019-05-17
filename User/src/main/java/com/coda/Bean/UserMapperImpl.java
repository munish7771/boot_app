package com.coda.Bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.coda.Entity.UserEntity;

public class UserMapperImpl implements UserMapper{

	@Override
	public UserEntity userToEntity(User user) {
		// TODO Auto-generated method stub
		return new UserEntity(user.getName(), user.getUsername(), user.getGender(), user.getPhoneNo(), user.getPassword());
	}

	@Override
	public User entityToUser(UserEntity entity) {
		// TODO Auto-generated method stub
		return new User(entity.getId(), entity.getName(), entity.getUsername(), entity.getGender(), entity.getPhoneno(), entity.getPassword());
	}

	@Override
	public List<User> userEntityListToUser(List<UserEntity> ue) {
		List<User> userList = new ArrayList<User>();
		ue.forEach(p->userList.add(this.entityToUser(p)));
		return userList;
	}

}
