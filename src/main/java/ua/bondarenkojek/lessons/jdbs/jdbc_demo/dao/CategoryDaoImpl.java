package ua.bondarenkojek.lessons.jdbs.jdbc_demo.dao;

import ua.bondarenkojek.lessons.jdbs.jdbc_demo.model.Book;
import ua.bondarenkojek.lessons.jdbs.jdbc_demo.model.Category;

import java.util.Set;

public class CategoryDaoImpl implements CategoryDao {
    @Override
    public void save(Category category) {

    }

    @Override
    public Set<Book> findAllBooks(Long categoryId) {
        return null;
    }
}
