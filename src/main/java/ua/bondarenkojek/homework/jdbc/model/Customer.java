package ua.bondarenkojek.homework.jdbc.model;

import lombok.Builder;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Builder
public class Customer {
    private long id;
    private String name;
    private Set<Project> projects;

    public void addProject(Project project) {
        project.setCustomer(this);
        projects.add(project);
    }
}
