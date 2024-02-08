package ru.simtest.springboot.dao;

import ru.simtest.springboot.model.User;

import java.util.List;

public interface UserDao {

    List<User> getAllUsers();
    void addUser(User user);
    void deleteUser(int userId);
    void updateUser(User user);
    User getUser(int UserId);
}
