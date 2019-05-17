package com.coda.Api;
 
import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coda.Bean.User;
import com.coda.DAL.RoleRepository;
import com.coda.DAL.UserRepository;
import com.coda.Entity.RoleEntity;
import com.coda.Entity.RoleName;
import com.coda.Entity.UserEntity;
import com.coda.Security.JwtProvider;
import com.coda.Security.LoginForm;
import com.coda.Security.SignUpForm;
import com.coda.Service.UserServiceImpl;

import lombok.extern.log4j.Log4j2;


@Log4j2
@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping(value={"/api/auth"})
public class AuthController {
	
	@Autowired
	UserServiceImpl userservice;

    @Autowired
    AuthenticationManager authenticationManager;
 
    @Autowired
    UserRepository userRepository;
 
    @Autowired
    RoleRepository roleRepository;
 
    @Autowired
    PasswordEncoder encoder;
 
    @Autowired
    JwtProvider jwtProvider;
    
    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {
    	try {
    	log.info("inside signin");
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );
        log.info(authentication.toString());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        log.info("before token generation, username is" + loginRequest.getUsername());
 
        String jwt = jwtProvider.generateJwtToken(authentication);
        User user = userservice.getUserByUsername(loginRequest.getUsername());
        user.setToken(jwt);
        log.info(jwt);
        log.info("after token generation");
        return ResponseEntity.ok(user);
    	}catch(Exception e) {
    		log.error(e.getMessage());
    		return ResponseEntity.ok("Error in credentials!");
    	}
    }
    
    @PostMapping("/signup")
    public ResponseEntity<String> registerUser(@Valid @RequestBody SignUpForm signUpRequest) {
        if(userRepository.existsByUsername(signUpRequest.getUsername())) {
            return new ResponseEntity<String>("Fail -> Username is already taken!",
                    HttpStatus.BAD_REQUEST);
        }
 
        // Creating user's account
        UserEntity user = new UserEntity(signUpRequest.getName(), signUpRequest.getUsername(), signUpRequest.getGender(),
                signUpRequest.getPhonenumber(), encoder.encode(signUpRequest.getPassword()));
 
        Set<String> strRoles = signUpRequest.getRole();
        Set<RoleEntity> roles = new HashSet<>();
 
        strRoles.forEach(role -> {
          switch(role) {
          case "admin":
            RoleEntity adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
                  .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
            roles.add(adminRole);
            
            break;
          case "pm":
                RoleEntity pmRole = roleRepository.findByName(RoleName.ROLE_PM)
                  .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
                roles.add(pmRole);
                
            break;
          default:
              RoleEntity userRole = roleRepository.findByName(RoleName.ROLE_USER)
                  .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
              roles.add(userRole);              
          }
        });
        
        user.setRoles(roles);
        userRepository.save(user);
 
        return ResponseEntity.ok().body("User registered successfully!");
    }

	
}
