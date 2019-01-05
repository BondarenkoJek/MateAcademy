package ua.bondarenkojek.homework.jdbc.service;

import ua.bondarenkojek.homework.jdbc.model.Developer;
import ua.bondarenkojek.homework.jdbc.model.Project;

import java.util.Set;

public interface ProjectService {
    void addProject(Project project);

    void addDeveloperForProject(Project project, Developer developer);

    Project getProjectById(long id);

    void updateProject(Project project);

    void deleteProject(long id);

    void removeDeveloperFromProject(Project project, Developer developer);

    Set<Project> findAll();

    Double getAllSalaryByProject(Project project);
}
