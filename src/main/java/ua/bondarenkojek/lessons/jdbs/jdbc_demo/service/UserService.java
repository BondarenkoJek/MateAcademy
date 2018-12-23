package ua.bondarenkojek.lessons.jdbs.jdbc_demo.service;

import ua.bondarenkojek.lessons.jdbs.jdbc_demo.model.User;

public interface UserService {
    User findByLogin(String login);
}
