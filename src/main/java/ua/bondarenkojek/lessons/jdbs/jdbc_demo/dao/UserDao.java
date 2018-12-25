package ua.bondarenkojek.lessons.jdbs.jdbc_demo.dao;

import ua.bondarenkojek.lessons.jdbs.jdbc_demo.model.User;

import java.util.List;

public interface UserDao {
    User findByLogin(String login);
    List<User> findAll();
}
