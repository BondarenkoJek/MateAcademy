package ua.bondarenkojek.lessons.jdbs.jdbc_demo.dao;

import ua.bondarenkojek.lessons.jdbs.jdbc_demo.ConnectionUtil;
import ua.bondarenkojek.lessons.jdbs.jdbc_demo.model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDaoImpl extends AbstractDao implements UserDao {

    public UserDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public User findByLogin(String login) {
        final String sql = "SELECT * FROM users WHERE login=\"" + login + "\"";

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            return rs.next() ? getUser(rs) : null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private User getUser(ResultSet rs) throws SQLException {
        return User.builder()
                .id(rs.getLong("user_id"))
                .name(rs.getString("name"))
                .login(rs.getString("login"))
                .password(rs.getString("password"))
                .sex(rs.getString("sex")).build();
    }
}
