package ua.bondarenkojek.lessons.jdbs.jdbc_demo.dao;

import ua.bondarenkojek.lessons.jdbs.jdbc_demo.model.User;

public interface UserDao {
    User findByLogin(String login);
}
