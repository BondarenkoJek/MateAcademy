package ua.bondarenkojek.homework.jdbc.dao;

import ua.bondarenkojek.homework.jdbc.model.Developer;
import ua.bondarenkojek.homework.jdbc.model.Skill;

import java.sql.Connection;
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

    }

    @Override
    public Developer getDeveloperById(long id) {
        final String sqlDev = "SELECT * FROM DEVELOPERS WHERE developer_id=\"" + id + "\"";
        final String sqlSkills = "SELECT * FROM skills WHERE developer_id=\"" + id + "\"";
        Developer developer = null;

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sqlDev);

            if (!rs.next())
                return developer;

            developer =  getDeveloper(rs);

            rs = statement.executeQuery(sqlSkills);

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
