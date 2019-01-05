package ua.bondarenkojek.homework.jdbc.dao.impl;

import ua.bondarenkojek.homework.jdbc.dao.AbstractDao;
import ua.bondarenkojek.homework.jdbc.dao.CompanyDao;
import ua.bondarenkojek.homework.jdbc.model.Company;
import ua.bondarenkojek.homework.jdbc.model.Customer;
import ua.bondarenkojek.homework.jdbc.model.Project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;

public class CompanyDaoImpl extends AbstractDao implements CompanyDao {
    public CompanyDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public void addCompany(Company company) {
        final String INSERT_COMPANY =
                "INSERT INTO companies(name) VALUE(?)";
        try {
            PreparedStatement statement = connection.prepareStatement(INSERT_COMPANY);
            statement.setString(1, company.getName());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Company getCompany(long id) {
        final String SELECT_COMPANY_BY_ID =
                "SELECT * " +
                        "FROM companies " +
                        "INNER JOIN projects ON projects.company_id = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_COMPANY_BY_ID);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return getCompany(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateCompany(Company company) {
        final String UPDATE_COMPANY =
                "UPDATE companies " +
                        "SET name=? " +
                        "WHERE company_id=?";
        try {
            PreparedStatement statement = connection.prepareStatement(UPDATE_COMPANY);
            statement.setString(1, company.getName());
            statement.setLong(2, company.getId());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCompany(long id) {
        final String DELETE_COMPANY =
                "DELETE " +
                        "FROM companies" +
                        "WHERE company_id = ?";
        final String DELETE_COMPANY_FROM_PROJECTS =
                "UPDATE projects " +
                        "SET company_id=null" +
                        "where company_id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(DELETE_COMPANY_FROM_PROJECTS);
            statement.setLong(1, id);
            statement.execute();

            statement = connection.prepareStatement(DELETE_COMPANY);
            statement.setLong(1, id);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Company getCompany(ResultSet rs) throws SQLException {
        Company company = Company.builder()
                .id(rs.getLong("companies.company_id"))
                .name(rs.getString("companies.name"))
                .projects(new HashSet<>())
                .build();
        while (rs.next()) {
            company.addProject(Project
                    .builder()
                    .id(rs.getLong("project_id"))
                    .name("projects.name")
                    .createDate(rs.getDate("date").toLocalDate())
                    .customer(Customer.builder().id(rs.getLong("customer_id")).build())
                    .cost(rs.getDouble("cost"))
                    .build());
        }
        return company;
    }
}
