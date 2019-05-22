package com.coda.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coda.Bean.User;
import com.coda.Bean.UserMapper;
import com.coda.Bean.UserMapperImpl;
import com.coda.DAL.UserRepository;
import com.coda.Entity.UserEntity;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    
    UserMapper mapper = new UserMapperImpl();

    public String createUser(User user) {
		log.info("In User service");
		UserEntity entity = (mapper.userToEntity(user));
		try {
			userRepository.saveAndFlush(entity);
			return "success";
		}catch(Exception e) {
			log.error("Error: " + e.getMessage() );
			return "error:UserService";
		}
    }

    public List<User> getUsers() {
        // TODO Auto-generated method stub
    	log.info("In User service");
    	List<User> userList = new ArrayList<User>();
    	try {
    		List<UserEntity> ue = userRepository.findAll();
    		System.out.println(ue);
         userList = mapper.userEntityListToUser(userRepository.findAll());
         return userList;
        }catch(Exception e) {
        	log.error("error: " + e.getMessage());
        	return userList;
        }
    }

    public boolean editUser(User user) {
		log.info("In User service");
		try {
			log.info("about to find username :" +user.getUsername());
			Optional<UserEntity> e = userRepository.findByUsername(user.getUsername());
			// entity fetched is null.
			if (e.isPresent()){
				userRepository.delete(userRepository.findUserbyUsername(user.getUsername()));
				userRepository.save(mapper.userToEntity(user));
				return true;
			}
			log.info("didnt find user with username");
			return false;
		}catch(Exception e) {
			log.error("Error: " + e.getMessage() );
			return false;
		}
    }

    public boolean deleteUser(String username) {
		log.info("In User service");
		UserEntity user = null;
		try {
			log.info("about to find username :" +username);
			// throws exception if no product is present.
			user = userRepository.findUserbyUsername(username);
			userRepository.delete(user);
			userRepository.flush();
			return true;
		}catch(Exception e) {
			log.error("Error: " + e.getMessage() );
			return false;
		}
    }

	@Override
	public User getUserByUsername(String username) {
    	log.info("In user service");
    	try {
    		return mapper.entityToUser(userRepository.findUserbyUsername(username));
    	}catch(Exception e) {
    		log.error(e.getMessage());
    		return null;
    	}
	}
    
//    public User getUserByUsername(String username) {
//    	log.info("In user service");
//    	try {
//    		return mapper.entityToUser(userRepository.findByUsername(username));
//    	}catch(Exception e) {
//    		log.error(e.getMessage());
//    		return null;
//    	}
//    }

}