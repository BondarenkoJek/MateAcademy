package ua.bondarenkojek.homework.jdbc.dao;

import ua.bondarenkojek.homework.jdbc.model.Developer;
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
        final String SELECT_LAST_INDEX =
                "SELECT MAX(developer_id) AS id FROM developers";
        final String INSERT_SKILLS_FOR_DEVELOPER =
                "INSERT INTO skills(type, level, developer_id VALUES(?, ?, ?)";

        try {
            PreparedStatement statement = connection.prepareStatement(INSERT_DEVELOPER);
            statement.setString(1, developer.getName());
            statement.setInt(2, developer.getAge());
            statement.setDouble(3, developer.getSalary());
            statement.execute();

            statement = connection.prepareStatement(SELECT_LAST_INDEX);
            statement.executeQuery();
            ResultSet set = statement.getResultSet();
            long lastDevIndex = set.getLong("id");

            statement = connection.prepareStatement(INSERT_SKILLS_FOR_DEVELOPER);

            for (Skill skill : developer.getSkills()) {
                statement.setString(1, skill.getTypeOfSkill().name());
                statement.setString(2, skill.getSkillLevel().name());
                statement.setLong(3, lastDevIndex);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Developer getDeveloperById(long id) {
        final String SELECT_DEVELOPER_BY_ID = "SELECT * FROM DEVELOPERS WHERE developer_id=\"" + id + "\"";
        final String SELECT_SKILL_BY_DEV_ID = "SELECT * FROM skills WHERE developer_id=\"" + id + "\"";
        Developer developer = null;

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(SELECT_DEVELOPER_BY_ID);

            if (!rs.next())
                return developer;

            developer =  getDeveloper(rs);

            rs = statement.executeQuery(SELECT_SKILL_BY_DEV_ID);

            while (rs.next()) {
                developer.addSkill(getSkill(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return developer;
    }

    @Override
    public void setDeveloper(Developer developer) {

    }

    @Override
    public void removeDeveloperById(long id) {

    }

    @Override
    public Set<Developer> findAllByTypeOfSkill(Skill.TypeOfSkill typeOfSkill) {
        return null;
    }

    @Override
    public Set<Developer> findAllByLevelOfSkill(Skill.SkillLevel skillLevel) {
        return null;
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

    private Skill getSkill(ResultSet set) throws SQLException {
        return Skill.builder()
                .id(set.getLong("skill_id"))
                .typeOfSkill(Skill.TypeOfSkill.valueOf(set.getString("type")))
                .skillLevel(Skill.SkillLevel.valueOf(set.getString("level")))
                .build();
    }
}
