package ua.bondarenkojek.lessons.jdbs.jdbc_demo.service;

import ua.bondarenkojek.lessons.jdbs.jdbc_demo.dao.UserDao;
import ua.bondarenkojek.lessons.jdbs.jdbc_demo.model.User;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User findByLogin(String login) {
        return userDao.findByLogin(login);
    }

    @Override
    public List<String> getAllNamesUpperCase() {
        return userDao.findAll().stream()
                .filter(Objects::nonNull)
                .map(User::getName)
                .filter(Objects::nonNull)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }
}
