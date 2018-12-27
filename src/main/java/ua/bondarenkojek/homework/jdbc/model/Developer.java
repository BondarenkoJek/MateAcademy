package ua.bondarenkojek.homework.jdbc.model;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class Developer {
    private long id;
    private String name;
    private int age;
    private double salary;
    private Set<Project> projects;
    private Set<Skill> skills;

    public void addSkill(Skill skill) {
        skill.setOwner(this);
        skills.add(skill);
    }

    public void addProject(Project project) {
        project.addDeveloper(this);
        projects.add(project);
    }
}
