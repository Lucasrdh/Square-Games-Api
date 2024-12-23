package com.squaresgames.Square.games.service.dao;

import org.apache.catalina.User;

import java.util.List;

public interface UserDAO {
    public List<User> getAllUsers();
    public User getUserById(int id);
    public User getUserByEmail(String email);
    public User getUserByUsername(String username);
    public User createUser(User user);
    public User updateUser(User user);
    public void deleteUser(int id);
}
