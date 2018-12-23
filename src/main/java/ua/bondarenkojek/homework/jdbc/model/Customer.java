package ua.bondarenkojek.homework.jdbc.model;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class Customer {
    private long id;
    private String name;
    private int numberOfProjects;
    private Set<Project> projects;
}
