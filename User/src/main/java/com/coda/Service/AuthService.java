package com.coda.Service;

import com.coda.Bean.Auth;

public interface AuthService {
	public boolean isValid(Auth auth);
	public boolean changePassword(Auth auth, String new_password);
	public boolean changeUsername(Auth auth, String new_username);
	public boolean getPassword(String username);	
	public Auth getAuth(String username);
}
