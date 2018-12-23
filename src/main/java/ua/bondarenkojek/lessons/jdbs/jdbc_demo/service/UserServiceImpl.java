package ua.bondarenkojek.lessons.jdbs.jdbc_demo.service;

import ua.bondarenkojek.lessons.jdbs.jdbc_demo.dao.UserDao;
import ua.bondarenkojek.lessons.jdbs.jdbc_demo.model.User;

public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User findByLogin(String login) {
        return userDao.findByLogin(login);
    }
}
