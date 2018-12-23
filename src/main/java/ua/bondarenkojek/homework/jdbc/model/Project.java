package ua.bondarenkojek.homework.jdbc.model;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class Project {
    private long id;
    private String name;
    private int numberOfDevelopers;
    private Set<Developer> developers;
}
