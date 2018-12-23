package ua.bondarenkojek.lessons.jdbs.jdbc_demo.model;

import lombok.Data;

import java.util.Set;

@Data
public class Category {
    private Long id;
    private String name;
    private Set<Book> books;
}
