package ua.bondarenkojek.homework.jdbc.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Data
@Builder
public class Company {
    private long id;
    private String name;
    private Set<Project> projects;

    public void addProject(Project project) {
        project.setCompany(this);
        projects.add(project);
    }
}
