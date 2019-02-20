package ua.bondarenkojek.homework.jdbc.service.impl;

import ua.bondarenkojek.homework.jdbc.dao.UserDao;
import ua.bondarenkojek.homework.jdbc.model.User;
import ua.bondarenkojek.homework.jdbc.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public User getById(Long id) {
        return userDao.getById(id);
    }

    @Override
    public User getByLogin(String login) {
        return userDao.getByLogin(login);
    }

    @Override
    public User getByToken(String token) {
        return userDao.getByToken(token);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public void remove(Long id) {
        userDao.remove(id);
    }
}
