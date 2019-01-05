package ua.bondarenkojek.homework.jdbc.dao.impl;

import ua.bondarenkojek.homework.jdbc.dao.AbstractDao;
import ua.bondarenkojek.homework.jdbc.dao.DeveloperDao;
import ua.bondarenkojek.homework.jdbc.model.Company;
import ua.bondarenkojek.homework.jdbc.model.Customer;
import ua.bondarenkojek.homework.jdbc.model.Developer;
import ua.bondarenkojek.homework.jdbc.model.Project;
import ua.bondarenkojek.homework.jdbc.model.Skill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

public class DeveloperDaoImpl extends AbstractDao implements DeveloperDao {

    public DeveloperDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public void addDeveloper(Developer developer) {
        final String INSERT_DEVELOPER =
                "INSERT INTO developers(name, age, salary) VALUES(?, ?, ?)";
        final String SELECT_LAST_DEVELOPER_INDEX =
                "SELECT MAX(developer_id) AS id FROM developers";
        final String INSERT_SKILLS_FOR_DEVELOPER =
                "INSERT INTO skills(type, level, developer_id) VALUES(?, ?, ?)";
        final String INSERT_DEVELOPER_PROJECT =
                "INSERT INTO developers_projects(developer_id, project_id) VALUES (?, ?)";

        try {
//Insert developer
            PreparedStatement statement = connection.prepareStatement(INSERT_DEVELOPER);
            statement.setString(1, developer.getName());
            statement.setInt(2, developer.getAge());
            statement.setDouble(3, developer.getSalary());
            statement.execute();

//Select last developer index
            ResultSet rs = statement.executeQuery(SELECT_LAST_DEVELOPER_INDEX);
            rs.next();
            long lastDevId = rs.getLong("id");

//Insert skills for developer
            statement = connection.prepareStatement(INSERT_SKILLS_FOR_DEVELOPER);
            for (Skill skill : developer.getSkills()) {
                statement.setString(1, skill.getTypeOfSkill().name());
                statement.setString(2, skill.getSkillLevel().name());
                statement.setLong(3, lastDevId);
                statement.execute();
            }

//Insert developer project relations
            for (Project project : developer.getProjects()) {
                statement = connection.prepareStatement(INSERT_DEVELOPER_PROJECT);
                statement.setLong(1, lastDevId);
                statement.setLong(2, project.getId());
                statement.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Developer getDeveloperById(long id) {
        final String SELECT_DEVELOPER_BY_ID = "SELECT * FROM DEVELOPERS WHERE developer_id=\"" + id + "\"";
        final String SELECT_SKILLS_BY_DEV_ID = "SELECT * FROM skills WHERE developer_id=\"" + id + "\"";
        final String SELECT_PROJECTS_BY_DEV_ID =
                "SELECT projects.project_id, projects.name, projects.date, projects.company_id, " +
                        "projects.customer_id, projects.cost " +
                        "FROM projects " +
                        "INNER JOIN developers_projects AS dp ON dp.project_id = projects.project_id " +
                        "WHERE developer_id=\"" + id + "\"";

        Developer developer = null;

        try {
//Select developer
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(SELECT_DEVELOPER_BY_ID);
            if (!rs.next()) {
                return developer;
            }
//Select skills
            developer = getDeveloper(rs);
            rs = statement.executeQuery(SELECT_SKILLS_BY_DEV_ID);
            while (rs.next()) {
                developer.addSkill(getSkill(rs));
            }
//Select projects
            rs = statement.executeQuery(SELECT_PROJECTS_BY_DEV_ID);
            while (rs.next()) {
                developer.addProject(getProject(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return developer;
    }

    @Override
    public void updateDeveloper(Developer developer) {
        final String UPDATE_DEVELOPER =
                "UPDATE developers SET name=?, age=?, salary=? WHERE developer_id=?";
        final String UPDATE_SKILLS_FOR_DEVELOPER =
                "UPDATE skills SET type=?, level=? WHERE skill_id=?";
        try {
//Update developer
            PreparedStatement statement = connection.prepareStatement(UPDATE_DEVELOPER);
            statement.setString(1, developer.getName());
            statement.setInt(2, developer.getAge());
            statement.setDouble(3, developer.getSalary());
            statement.setLong(4, developer.getId());
            statement.execute();

//Update skills for developer
            statement = connection.prepareStatement(UPDATE_SKILLS_FOR_DEVELOPER);
            for (Skill skill : developer.getSkills()) {
                statement.setString(1, skill.getTypeOfSkill().name());
                statement.setString(2, skill.getSkillLevel().name());
                statement.setLong(3, skill.getId());
                statement.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeDeveloperById(long id) {
        final String DELETE_DEVELOPER_BY_ID = "DELETE FROM developers WHERE developer_id=?";
        final String DELETE_SKILLS_BY_DEV_ID = "DELETE FROM skills WHERE developer_id=?";
        final String DELETE_RELATIONS_WITH_PROJECTS_BY_DEV_ID = "DELETE FROM developers_projects WHERE developer_id=?";

        try {
//Delete skills
            PreparedStatement statement = connection.prepareStatement(DELETE_SKILLS_BY_DEV_ID);
            statement.setLong(1, id);
            statement.execute();

//Delete developer projects relations
            statement = connection.prepareStatement(DELETE_RELATIONS_WITH_PROJECTS_BY_DEV_ID);
            statement.setLong(1, id);
            statement.execute();

//Delete developer
            statement = connection.prepareStatement(DELETE_DEVELOPER_BY_ID);
            statement.setLong(1, id);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Set<Developer> findAllByTypeOfSkill(Skill.TypeOfSkill typeOfSkill) {
        final String SELECT_DEV_BY_TYPE_OF_SKILL =
                "SELECT developers.developer_id FROM developers " +
                        "INNER JOIN skills ON skills.developer_id = developers.developer_id " +
                        "WHERE skills.type=\"" + typeOfSkill + "\"";
        return getDevelopers(SELECT_DEV_BY_TYPE_OF_SKILL);
    }

    @Override
    public Set<Developer> findAllByLevelOfSkill(Skill.SkillLevel skillLevel) {
        final String SELECT_DEV_BY_LEVEL_OF_SKILL =
                "SELECT developers.developer_id FROM developers " +
                        "INNER JOIN skills ON skills.developer_id = developers.developer_id " +
                        "WHERE skills.level=\"" + skillLevel + "\"";
        return getDevelopers(SELECT_DEV_BY_LEVEL_OF_SKILL);
    }

    @Override
    public Set<Developer> findAllDevelopersByProject(Project project) {
        final String SELECT_DEV_BY_PROJECT =
                "SELECT developers.developer_id FROM developers " +
                        "INNER JOIN developers_projects AS dp ON dp.developer_id = developers.developer_id " +
                        "WHERE dp.project_id=" + project.getId();
        return getDevelopers(SELECT_DEV_BY_PROJECT);
    }

    private Developer getDeveloper(ResultSet set) throws SQLException {
        return Developer.builder()
                .id(set.getLong("developer_id"))
                .name(set.getString("name"))
                .age(set.getInt("age"))
                .salary(set.getDouble("salary"))
                .skills(new HashSet<>())
                .projects(new HashSet<>())
                .build();
    }

    private Set<Developer> getDevelopers(String query) {
        Set<Developer> developers = new HashSet<>();
        Set<Long> developersId = new HashSet<>();

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                developersId.add(rs.getLong("developer_id"));
            }
            developersId.forEach(id -> developers.add(getDeveloperById(id)));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return developers;
    }

    private Skill getSkill(ResultSet set) throws SQLException {
        return Skill.builder()
                .id(set.getLong("skill_id"))
                .typeOfSkill(Skill.TypeOfSkill.valueOf(set.getString("type")))
                .skillLevel(Skill.SkillLevel.valueOf(set.getString("level")))
                .build();
    }

    private Project getProject(ResultSet set) throws SQLException {
        return Project.builder()
                .id(set.getLong("project_id"))
                .name("name")
                .createDate(set.getDate("date").toLocalDate())
                .company(Company.builder().id(set.getLong("company_id")).build())
                .customer(Customer.builder().id(set.getLong("customer_id")).build())
                .cost(set.getDouble("cost"))
                .build();
    }
}
