package com.coda.DAL;
import org.springframework.data.jpa.repository.JpaRepository;
import com.coda.Entity.AuthEntity;
public interface AuthRepository extends JpaRepository<AuthEntity, String>{
	// no need for auth repository
	//wont fetch the password anywhere in the code
//	@Query("select u.username from AuthEntity u where u.username = ?1 and u.password = ?2")
//	public String isValid(String username, String password);
//	
//	@Query("select u.password from Authentity u where u.username = ?1")
//	public String getPassword(String username);
//	
//	@Query("select u from Authentity u where u.username = ?1")
//	public AuthEntity getAuth(String username);
}
