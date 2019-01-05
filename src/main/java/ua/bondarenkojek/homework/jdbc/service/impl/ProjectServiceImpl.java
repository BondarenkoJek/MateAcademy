package ua.bondarenkojek.homework.jdbc.service.impl;

import ua.bondarenkojek.homework.jdbc.dao.ProjectDao;
import ua.bondarenkojek.homework.jdbc.model.Developer;
import ua.bondarenkojek.homework.jdbc.model.Project;
import ua.bondarenkojek.homework.jdbc.service.ProjectService;

import java.util.Set;

public class ProjectServiceImpl implements ProjectService {
    private ProjectDao projectDao;

    public ProjectServiceImpl(ProjectDao projectDao) {
        this.projectDao = projectDao;
    }

    @Override
    public void addProject(Project project) {
        projectDao.addProject(project);
    }

    @Override
    public void addDeveloperForProject(Project project, Developer developer) {
        projectDao.addDeveloperForProject(project, developer);
    }

    @Override
    public Project getProjectById(long id) {
        return projectDao.getProjectById(id);
    }

    @Override
    public void updateProject(Project project) {
        projectDao.updateProject(project);
    }

    @Override
    public void deleteProject(long id) {
        projectDao.deleteProject(id);
    }

    @Override
    public void removeDeveloperFromProject(Project project, Developer developer) {
        projectDao.removeDeveloperFromProject(project, developer);
    }

    @Override
    public Set<Project> findAll() {
        return projectDao.findAll();
    }

    @Override
    public Double getAllSalaryByProject(Project project) {
        return projectDao.getAllSalaryByProject(project);
    }
}
