package ua.bondarenkojek.homework.jdbc.dao;

import ua.bondarenkojek.homework.jdbc.model.Developer;
import ua.bondarenkojek.homework.jdbc.model.Skill;

import java.util.Set;

public interface DeveloperDao {

    void addDeveloper(Developer developer);

    Developer getDeveloperById(long id);

    void setDeveloper(Developer developer);

    void removeDeveloperById(long id);

    Set<Developer> findAllByTypeOfSkill(Skill.TypeOfSkill typeOfSkill);

    Set<Developer> findAllByLevelOfSkill(Skill.SkillLevel skillLevel);
}
