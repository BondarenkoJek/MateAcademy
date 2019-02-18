package ua.bondarenkojek.homework.jdbc.dao.impl;

import ua.bondarenkojek.homework.jdbc.dao.AbstractDao;
import ua.bondarenkojek.homework.jdbc.dao.UserDao;
import ua.bondarenkojek.homework.jdbc.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl extends AbstractDao implements UserDao {

    public UserDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public void add(User user) {
        final String INSERT_USER =
                "INSERT INTO users(login, password, email) VALUE(?, ?, ?)";
        save(INSERT_USER, user);
    }

    @Override
    public User getById(Long id) {
        final String SELECT_USER_BY_ID =
                "SELECT login, password, email FROM users WHERE id = ?";
       return get(SELECT_USER_BY_ID, id);
    }

    @Override
    public User getByLogin(String login) {
        final String SELECT_USER_BY_LOGIN =
                "SELECT login, password, email FROM users WHERE login = ?";
        return get(SELECT_USER_BY_LOGIN, login);
    }

    @Override
    public User getByToken(String token) {
        final String SELECT_USER_BY_TOKEN =
                "SELECT login, password, email FROM users WHERE login = ?";
        return get(SELECT_USER_BY_TOKEN, token);
    }

    @Override
    public void update(User user) {
        final String UPDATE_USER =
                "UPDATE users " +
                        "SET login=?, password=?, email=?" +
                        "WHERE id=?";
        save(UPDATE_USER, user);
    }

    @Override
    public void remove(Long id) {
        final String DELETE_USER =
                "DELETE " +
                        "FROM users" +
                        "WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(DELETE_USER);
            statement.setLong(1, id);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void save(String sql, User user) {
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getEmail());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private User get(String sql, Object param) {
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setObject(1, param);
            ResultSet rs = statement.executeQuery();

            return getUser(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private User getUser(ResultSet rs) throws SQLException {
        if (rs.next()) {
            User user = User.builder()
                    .id(rs.getLong("users.id"))
                    .login(rs.getString("users.login"))
                    .password(rs.getString("users.password"))
                    .email(rs.getString("users.email"))
                    .build();
            return user;
        }
        return null;
    }
}
