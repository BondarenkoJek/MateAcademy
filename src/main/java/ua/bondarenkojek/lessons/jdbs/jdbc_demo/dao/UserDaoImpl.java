package ua.bondarenkojek.lessons.jdbs.jdbc_demo.dao;

import ua.bondarenkojek.lessons.jdbs.jdbc_demo.model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<User> findAll() {
        final String sql = "SELECT * FROM users";
        List<User> list = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                list.add(getUser(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


    private User getUser(ResultSet rs) throws SQLException {
        User user = new User();

        return user;

    }
}
