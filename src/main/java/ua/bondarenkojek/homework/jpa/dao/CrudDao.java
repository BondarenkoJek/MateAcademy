package ua.bondarenkojek.homework.jpa.dao;

import java.io.Serializable;

public interface CrudDao<T, ID extends Serializable> {
    T create(T entity);

    T read(ID id);

    void update(T entity);

    void delete(T entity);
}
