package ua.bondarenkojek.homework.jpa.dao;

import javax.persistence.EntityManager;
import java.io.Serializable;

public abstract class AbstractDao<T, ID extends Serializable> implements CrudDao<T, ID> {
    protected final EntityManager entityManager;
    protected final Class<T> clazz;

    public AbstractDao(EntityManager entityManager, Class<T> clazz) {
        this.entityManager = entityManager;
        this.clazz = clazz;
    }

    @Override
    public T create(T entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        return read((ID) entityManager
                .createQuery("select max(e.id) from " + clazz.getName() +" e", clazz));
    }

    @Override
    public T read(ID id) {
        entityManager.getTransaction().begin();
        T entity = entityManager.find(clazz, id);
        entityManager.getTransaction().commit();
        return entity;
    }

    @Override
    public void update(T entity) {
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(T entity) {
        entityManager.getTransaction().begin();
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
    }
}
