package ua.bondarenkojek.homework.jdbc.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@Builder
@ToString
public class Project {
    private long id;
    private String name;
    private Set<Developer> developers;
    private LocalDate createDate;
    private Company company;
    private Customer customer;
    private double cost;

    public void addDeveloper(Developer developer) {
        developers.add(developer);
    }
}
