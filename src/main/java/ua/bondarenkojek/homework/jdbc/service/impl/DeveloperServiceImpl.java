package ua.bondarenkojek.homework.jdbc.service.impl;

import ua.bondarenkojek.homework.jdbc.dao.DeveloperDao;
import ua.bondarenkojek.homework.jdbc.model.Developer;
import ua.bondarenkojek.homework.jdbc.model.Project;
import ua.bondarenkojek.homework.jdbc.model.Skill;
import ua.bondarenkojek.homework.jdbc.service.DeveloperService;

import java.util.Set;

public class DeveloperServiceImpl implements DeveloperService {
    private DeveloperDao developerDao;

    public DeveloperServiceImpl(DeveloperDao developerDao) {
        this.developerDao = developerDao;
    }

    @Override
    public void addDeveloper(Developer developer) {
        developerDao.addDeveloper(developer);
    }

    @Override
    public Developer getDeveloperById(long id) {
        return developerDao.getDeveloperById(id);
    }

    @Override
    public void updateDeveloper(Developer developer) {
        developerDao.updateDeveloper(developer);
    }

    @Override
    public void removeDeveloperById(long id) {
        developerDao.removeDeveloperById(id);
    }

    @Override
    public Set<Developer> findAllByTypeOfSkill(String typeOfSkill) {
        return developerDao.findAllByTypeOfSkill(Skill.TypeOfSkill.valueOf(typeOfSkill.toUpperCase()));
    }

    @Override
    public Set<Developer> findAllByTypeOfSkill(Skill.TypeOfSkill typeOfSkill) {
        return developerDao.findAllByTypeOfSkill(typeOfSkill);
    }

    @Override
    public Set<Developer> findAllByLevelOfSkill(String skillLevel) {
        return developerDao.findAllByLevelOfSkill(Skill.SkillLevel.valueOf(skillLevel.toUpperCase()));
    }

    @Override
    public Set<Developer> findAllDevelopersByProject(Project project) {
        return developerDao.findAllDevelopersByProject(project);
    }

    @Override
    public Set<Developer> findAllByLevelOfSkill(Skill.SkillLevel skillLevel) {
        return developerDao.findAllByLevelOfSkill(skillLevel);
    }
}
