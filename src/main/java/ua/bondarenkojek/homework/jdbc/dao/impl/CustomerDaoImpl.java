package ua.bondarenkojek.homework.jdbc.dao.impl;

import ua.bondarenkojek.homework.jdbc.dao.AbstractDao;
import ua.bondarenkojek.homework.jdbc.dao.CustomerDao;
import ua.bondarenkojek.homework.jdbc.model.Customer;
import ua.bondarenkojek.homework.jdbc.model.Project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;

public class CustomerDaoImpl extends AbstractDao implements CustomerDao {
    public CustomerDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public void addCustomer(Customer customer) {
        final String INSERT_CUSTOMER =
                "INSERT INTO customers(name) VALUE(?)";
        try {
            PreparedStatement statement = connection.prepareStatement(INSERT_CUSTOMER);
            statement.setString(1, customer.getName());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Customer getCustomer(long id) {
        final String SELECT_CUSTOMER_BY_ID =
                "SELECT name FROM customers WHERE customer_id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_CUSTOMER_BY_ID);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();

                return getCustomer(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateCustomer(Customer customer) {
        final String UPDATE_CUSTOMER =
                "UPDATE customers " +
                        "SET name=? " +
                        "WHERE customer_id=?";
        try {
            PreparedStatement statement = connection.prepareStatement(UPDATE_CUSTOMER);
            statement.setString(1, customer.getName());
            statement.setLong(2, customer.getId());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCustomer(long id) {
        final String DELETE_CUSTOMER =
                "DELETE " +
                        "FROM customers" +
                        "WHERE customer_id = ?";
        final String DELETE_CUSTOMER_FROM_PROJECTS =
                "UPDATE projects " +
                        "SET customer_id=null" +
                        "where customer_id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(DELETE_CUSTOMER_FROM_PROJECTS);
            statement.setLong(1, id);
            statement.execute();

            statement = connection.prepareStatement(DELETE_CUSTOMER);
            statement.setLong(1, id);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Customer getCustomer(ResultSet rs) throws SQLException {
        if (rs.next()) {
            Customer customer = Customer.builder()
                    .id(rs.getLong("customers.customer_id"))
                    .name(rs.getString("customers.name"))
                    .projects(new HashSet<>())
                    .build();
            while (rs.next()) {
                customer.addProject(Project
                        .builder()
                        .id(rs.getLong("project_id"))
                        .name("projects.name")
                        .createDate(rs.getDate("date").toLocalDate())
                        .customer(Customer.builder().id(rs.getLong("company_id")).build())
                        .cost(rs.getDouble("cost"))
                        .build());
            }
            return customer;
        }
        return null;
    }
}
