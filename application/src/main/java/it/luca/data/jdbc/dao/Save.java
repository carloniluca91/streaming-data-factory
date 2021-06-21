package it.luca.data.jdbc.dao;

import org.jdbi.v3.sqlobject.customizer.BindMethods;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

public interface Save<T> {

    @SqlUpdate
    void save(@BindMethods("r") T record);
}
