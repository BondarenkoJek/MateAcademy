package ua.bondarenkojek.homework.jdbc.dao;

import java.sql.Connection;

public abstract class AbstractDao {
    protected final Connection connection;

    protected AbstractDao(Connection connection) {
        this.connection = connection;
    }
}
