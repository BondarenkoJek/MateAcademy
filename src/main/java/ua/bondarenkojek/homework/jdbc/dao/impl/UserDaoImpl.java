package ua.bondarenkojek.homework.jdbc.dao.impl;

import ua.bondarenkojek.homework.jdbc.dao.AbstractDao;
import ua.bondarenkojek.homework.jdbc.dao.UserDao;
import ua.bondarenkojek.homework.jdbc.model.Role;
import ua.bondarenkojek.homework.jdbc.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class UserDaoImpl extends AbstractDao implements UserDao {

    public UserDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public void add(User user) {
        final String INSERT_USER =
                "INSERT INTO users(login, password, email, token) VALUE(?, ?, ?, ?)";
        save(INSERT_USER, user);
    }

    @Override
    public User getById(Long id) {
        return getUser(id, "users.id");
    }

    @Override
    public User getByLogin(String login) {
        return getUser(login, "users.login");
    }

    @Override
    public User getByToken(String token) {
        return getUser(token, "users.token");
    }

    @Override
    public void update(User user) {
        final String UPDATE_USER =
                "UPDATE users " +
                        "SET login=?, password=?, email=?, token=?" +
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
            statement.setString(4, user.getToken());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private User getUser(Object param, String conditional) {
        final String SELECT_USER = String.format("SELECT * " +
                "FROM users " +
                "INNER JOIN users_roles ON users.id = users_roles.user_id " +
                "INNER JOIN roles ON users_roles.role_id = roles.id " +
                "WHERE %s = ?;", conditional);
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_USER);
            statement.setObject(1, param);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return getUser(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private User getUser(ResultSet rs) throws SQLException {

        return User.builder()
                .id(rs.getLong("users.id"))
                .login(rs.getString("login"))
                .password(rs.getString("password"))
                .email(rs.getString("email"))
                .token(rs.getString("token"))
                .roles(getRoles(rs))
                .build();
    }

    private Set<Role> getRoles(ResultSet rs) throws SQLException {
        Set<Role> roles = new HashSet<>();
        do {
            roles.add(new Role(
                    rs.getLong("roles.id"),
                    rs.getString("name")));
        } while (rs.next());
        return roles;
    }
}
