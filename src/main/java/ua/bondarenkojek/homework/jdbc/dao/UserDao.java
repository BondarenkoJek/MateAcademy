package ua.bondarenkojek.homework.jdbc.dao;

import ua.bondarenkojek.homework.jdbc.model.User;

public interface UserDao {
    void add(User user);

    User getById(Long id);

    User getByLogin(String login);

    User getByToken(String token);

    void update(User user);

    void remove(Long id);
}
