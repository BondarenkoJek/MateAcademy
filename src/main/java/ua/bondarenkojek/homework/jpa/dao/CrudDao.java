package ua.bondarenkojek.homework.jpa.dao;

public interface CrudDao<T> {
    Long createEntity(T entity);

    T readEntity(Long id);

    void updateEntity(T entity);

    void deleteEntity(T entity);
}
