package com.coda.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.coda.Bean.Auth;
import com.coda.DAL.AuthRepository;
import com.coda.Entity.AuthEntity;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service("authService")
public class AuthServiceImpl implements AuthService{

	@Autowired
	AuthRepository repository;
	
	@Override
	public boolean isValid(Auth auth) {
//		log.info("In authService:");
//		try {
//			return repository.isValid(auth.getUsername(), auth.getPassword()) != null;
//		}catch(Exception e) {
//			log.error("error:in isValid");
//			return false;
//		}
		return true;
	}

	@Override
	public boolean changePassword(Auth auth, String new_password) {
		
		return false;
	}

	@Override
	public boolean changeUsername(Auth auth, String new_username) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getPassword(String username) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Auth getAuth(String username) {
//		log.info("In authService:");
//		AuthEntity ae = null;
//		try {
//			ae = repository.getAuth(username);
//			Auth auth = new Auth();
//			auth.setPassword(ae.getPassword());
//			auth.setUsername(ae.getUsername());
//			return auth;
//		}catch(Exception e) {
//			log.error(e.getMessage());
//		}
//		return null;
		return null;
	}

}
