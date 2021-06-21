package it.luca.data.jdbc.dao;

import org.jdbi.v3.sqlobject.customizer.BindMethods;
import org.jdbi.v3.sqlobject.customizer.Define;
import org.jdbi.v3.sqlobject.locator.UseClasspathSqlLocator;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.stringtemplate4.UseStringTemplateEngine;

public interface Save<T> {

    @SqlUpdate
    void save(@Define("tableName") String tableName, @BindMethods("record") T record);
}
