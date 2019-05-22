package com.coda.Service;

import java.util.List;

import com.coda.Bean.User;
public interface UserService {
    public String createUser(User user);
    public List<User> getUsers();
    public boolean editUser(User user);
    public boolean deleteUser(String username);
    public User getUserByUsername(String username);
}
