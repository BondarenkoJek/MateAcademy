package ua.bondarenkojek.homework.jdbc.model;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class Project {
    private long id;
    private String name;
    private Set<Developer> developers;

    public void addDeveloper(Developer developer) {
        developers.add(developer);
    }
}
