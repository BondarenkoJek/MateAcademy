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
    private int numberOfSkills;
    private int numberOfProjects;
    private Set<Project> projects;
    private Set<Skill> skills;
}
