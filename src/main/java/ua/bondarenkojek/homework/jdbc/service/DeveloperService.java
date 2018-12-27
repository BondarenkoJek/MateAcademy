package ua.bondarenkojek.homework.jdbc.service;

import ua.bondarenkojek.homework.jdbc.model.Developer;
import ua.bondarenkojek.homework.jdbc.model.Skill;

import java.util.Set;

public interface DeveloperService {
    void addDeveloper(Developer developer);

    Developer getDeveloperById(long id);

    void setDeveloper(Developer developer);

    void removeDeveloperById(long id);

    Set<Developer> findAllByTypeOfSkill(String typeOfSkill);

    Set<Developer> findAllByTypeOfSkill(Skill.TypeOfSkill typeOfSkill);

    Set<Developer> findAllByLevelOfSkill(String skillLevel);

    Set<Developer> findAllByLevelOfSkill(Skill.SkillLevel skillLevel);
}
