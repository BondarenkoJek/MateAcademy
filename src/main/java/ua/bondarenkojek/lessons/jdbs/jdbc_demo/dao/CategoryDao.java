package ua.bondarenkojek.lessons.jdbs.jdbc_demo.dao;

import ua.bondarenkojek.lessons.jdbs.jdbc_demo.model.Book;
import ua.bondarenkojek.lessons.jdbs.jdbc_demo.model.Category;

import java.util.Set;

public interface CategoryDao {
    void save(Category category);
    Set<Book> findAllBooks(Long categoryId);
}
