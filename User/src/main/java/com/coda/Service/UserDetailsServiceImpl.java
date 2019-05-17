package com.coda.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.coda.DAL.UserRepository;
import com.coda.Entity.UserEntity;
import com.coda.Security.UserPrinciple;
@Service("userDetailService")
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	UserRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = repository.findByUsername(username)
                .orElseThrow(() -> 
                      new UsernameNotFoundException("User Not Found with -> username or email : " + username)
      );

      return UserPrinciple.build(user);
	}

}
