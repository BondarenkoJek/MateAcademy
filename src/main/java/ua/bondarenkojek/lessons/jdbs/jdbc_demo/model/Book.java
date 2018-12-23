package ua.bondarenkojek.lessons.jdbs.jdbc_demo.model;

import lombok.Data;

@Data
public class Book {
    private Long id;
    private String title;
    private String author;
    private Category category;
}
