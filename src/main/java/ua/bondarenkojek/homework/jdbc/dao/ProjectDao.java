package ua.bondarenkojek.homework.jdbc.dao;

import ua.bondarenkojek.homework.jdbc.model.Developer;
import ua.bondarenkojek.homework.jdbc.model.Project;

import java.util.Set;

public interface ProjectDao {
    void addProject(Project project);
    void addDeveloperForProject(Project project, Developer developer);
    Project getProjectById(long id);
    void updateProject(Project project);
    void deleteProject(long id);
    void removeDeveloperFromProject(Project project, Developer developer);

    Set<Project> findAll();
    Double getAllSalaryByProject(Project project);
}
