package ua.bondarenkojek.homework.jdbc.model;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class Company {
    private long id;
    private String name;
    private Set<Project> projects;
}
