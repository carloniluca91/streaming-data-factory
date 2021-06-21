package it.luca.data.jdbc.dao;

import it.luca.data.jdbc.dto.SampleGenerationRecord;
import org.jdbi.v3.sqlobject.locator.UseClasspathSqlLocator;
import org.jdbi.v3.stringtemplate4.UseStringTemplateEngine;

@UseClasspathSqlLocator
@UseStringTemplateEngine
public interface SampleGenerationRecordDao extends Save<SampleGenerationRecord> {}
