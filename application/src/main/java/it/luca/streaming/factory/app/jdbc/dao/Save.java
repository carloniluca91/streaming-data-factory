package it.luca.streaming.factory.app.jdbc.dao;

import org.jdbi.v3.sqlobject.customizer.BindMethods;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

public interface Save<T> {

    @SqlUpdate
    void save(@BindMethods("r") T record);
}
