package ua.bondarenkojek.lessons.jdbs.jdbc_demo.service;

import ua.bondarenkojek.lessons.jdbs.jdbc_demo.model.User;

import java.util.List;

public interface UserService {
    User findByLogin(String login);
    List<String> getAllNamesUpperCase();

}
