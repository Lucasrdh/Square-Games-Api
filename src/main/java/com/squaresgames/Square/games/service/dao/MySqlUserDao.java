package com.squaresgames.Square.games.service.dao;

import org.apache.catalina.User;

import java.util.List;

public class MySqlUserDao implements UserDAO{

    @Override
    public List<User> getAllUsers() {
        return List.of();
    }

    @Override
    public User getUserById(int id) {
        return null;
    }

    @Override
    public User getUserByEmail(String email) {
        return null;
    }

    @Override
    public User getUserByUsername(String username) {
        return null;
    }

    @Override
    public User createUser(User user) {
        String query = "INSERT INTO users (name, email) VALUES (?, ?)";
        return user;
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public void deleteUser(int id) {

    }
}
