package ua.bondarenkojek.homework.jdbc.dao;

import ua.bondarenkojek.homework.jdbc.model.Company;
import ua.bondarenkojek.homework.jdbc.model.Customer;
import ua.bondarenkojek.homework.jdbc.model.Developer;
import ua.bondarenkojek.homework.jdbc.model.Project;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class ProjectDaoImpl extends AbstractDao implements ProjectDao {
    public ProjectDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public void addProject(Project project) {
        final String INSERT_PROJECT =
                "INSERT INTO projects(name, date, company_id, customer_id, cost) VALUES(?, ?, ?, ?, ?)";
        final String SELECT_LAST_PROJECT_ID =
                "SELECT MAX(project_id) AS id " +
                        "FROM projects";

        final String INSERT_DEVELOPERS_PROJECTS =
                "INSERT INTO developers_projects(developer_id, project_id) VALUES(?, ?)";
        try {
//Insert project
            PreparedStatement statement = connection.prepareStatement(INSERT_PROJECT);
            statement.setString(1, project.getName());
            statement.setDate(2, Date.valueOf(project.getCreateDate()));
            statement.setLong(3, project.getCompany().getId());
            statement.setLong(4, project.getCustomer().getId());
            statement.setDouble(5, project.getCost());
            statement.execute();

            ResultSet rs = statement.executeQuery(SELECT_LAST_PROJECT_ID);
            rs.next();
            long lastProjectId = rs.getLong("id");
            statement = connection.prepareStatement(INSERT_DEVELOPERS_PROJECTS);

            for (Developer developer : project.getDevelopers()) {
                statement.setLong(1, developer.getId());
                statement.setLong(2, lastProjectId);
                statement.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addDeveloperForProject(Project project, Developer developer) {
        final String INSERT_DEVELOPER_PROJECT =
                "INSERT INTO developers_projects(developer_id, project_id) VALUES (?, ?)";
        doRelationProjectWithDeveloper(INSERT_DEVELOPER_PROJECT, project.getId(), developer.getId());
    }

    @Override
    public Project getProjectById(long id) {
        final String SELECT_PROJECT_BY_ID =
                "SELECT *\n" +
                        "FROM projects\n" +
                        "INNER JOIN developers_projects AS dp\n" +
                        "ON projects.project_id = dp.project_id\n" +
                        "INNER JOIN developers\n" +
                        "ON dp.developer_id = developers.developer_id\n" +
                        "WHERE projects.project_id = ?;";
        Project project = null;
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_PROJECT_BY_ID);
            statement.setLong(1, id);
            project = getProject(statement.executeQuery());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return project;
    }

    @Override
    public void updateProject(Project project) {
        final String UPDATE_PROJECTS =
                "UPDATE projects " +
                        "SET name=?, date=?, company_id=?, customer_id=?, cost=? " +
                        "WHERE project_id=?";
        try {
            PreparedStatement statement = connection.prepareStatement(UPDATE_PROJECTS);
            statement.setString(1, project.getName());
            statement.setDate(2, Date.valueOf(project.getCreateDate()));
            statement.setLong(3, project.getCompany().getId());
            statement.setLong(4, project.getCustomer().getId());
            statement.setDouble(5, project.getCost());
            statement.setLong(6, project.getId());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteProject(long id) {
        final String DELETE_PROJECT_BY_ID =
                "DELETE FROM projects " +
                        "WHERE project_id=?";
        final String DELETE_RELATIONS_WITH_DEV_BY_PROJECT_ID =
                "DELETE FROM developers_projects " +
                        "WHERE project_id=?";
        try {
//Delete developer projects relations
            PreparedStatement statement = connection.prepareStatement(DELETE_RELATIONS_WITH_DEV_BY_PROJECT_ID);
            statement.setLong(1, id);
            statement.execute();

//Delete project
            statement = connection.prepareStatement(DELETE_PROJECT_BY_ID);
            statement.setLong(1, id);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeDeveloperFromProject(Project project, Developer developer) {
        final String DELETE_RELATIONS_WITH_DEV_BY_PROJECT_ID =
                "DELETE " +
                        "FROM developers_projects " +
                        "WHERE project_id=? AND developer_id=?";
        doRelationProjectWithDeveloper(DELETE_RELATIONS_WITH_DEV_BY_PROJECT_ID, project.getId(), developer.getId());
    }

    @Override
    public Double getAllSalaryByProject(Project project) {
        Double sumSalary = null;
        final String SELECT_SUM_DEV_SALARY_BY_PROJECT =
                "SELECT SUM(salary) AS salaries" +
                        "FROM developers " +
                        "INNER JOIN developers_projects AS dp " +
                        "ON dp.developer_id = developers.developer_id " +
                        "WHERE dp.project_id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_SUM_DEV_SALARY_BY_PROJECT);
            statement.setLong(1, project.getId());
            ResultSet rs = statement.executeQuery();
            sumSalary = rs.getDouble("salaries");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sumSalary;
    }

    @Override
    public Set<Project> findAll() {
        Set<Project> projects = new HashSet<>();
        Set<Long> projectsId = new HashSet<>();
        final String SELECT_ALL_ID =
                "SELECT project_id " +
                        "FROM projects";
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_ID);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                projectsId.add(rs.getLong("project_id"));
            }

            projectsId.forEach(id -> projects.add(getProjectById(id)));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return projects;
    }

    private Project getProject(ResultSet rs) throws SQLException {
        Project project = null;
//Adding data to project without developers
        if (rs.next()) {
            project = Project.builder()
                    .id(rs.getLong("projects.project_id"))
                    .name(rs.getString("projects.name"))
                    .createDate(rs.getDate("date").toLocalDate())
                    .company(Company
                            .builder()
                            .id(rs.getLong("company_id"))
                            .build())
                    .customer(Customer
                            .builder()
                            .id(rs.getLong("customer_id"))
                            .build())
                    .cost(rs.getDouble("cost"))
                    .developers(new HashSet<>())
                    .build();

//Adding data developers to project
            do {
                project.addDeveloper(Developer
                        .builder()
                        .id(rs.getLong("developers.developer_id"))
                        .name(rs.getString("developers.name"))
                        .age(rs.getInt("age"))
                        .salary(rs.getDouble("salary"))
                        .build());
            } while (rs.next());
        }
        return project;
    }

    private void doRelationProjectWithDeveloper(String query, long projectId, long developerId) {
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, projectId);
            statement.setLong(2, developerId);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
