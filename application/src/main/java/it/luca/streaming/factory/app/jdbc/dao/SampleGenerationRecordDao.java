package it.luca.streaming.factory.app.jdbc.dao;

import it.luca.streaming.factory.app.jdbc.dto.SampleGenerationRecord;
import org.jdbi.v3.sqlobject.locator.UseClasspathSqlLocator;
import org.jdbi.v3.stringtemplate4.UseStringTemplateEngine;

@UseClasspathSqlLocator
@UseStringTemplateEngine
public interface SampleGenerationRecordDao extends Save<SampleGenerationRecord> {}
