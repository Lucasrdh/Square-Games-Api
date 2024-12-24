package com.squaresgames.Square.games.service.dao;

import com.squaresgames.Square.games.database.DatabaseConnection;
import org.apache.catalina.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MySqlUserDao implements UserDAO {

    public MySqlUserDao() {
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String query = "select * from users";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {

                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");

                User user = new User(id, name, email);

                users.add(user);
            }

        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
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
