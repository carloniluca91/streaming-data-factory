package it.luca.data.jdbc.dao;

import it.luca.data.jdbc.dto.SampleGenerationRecord;
import lombok.extern.slf4j.Slf4j;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.postgres.PostgresPlugin;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@Slf4j
@Component
public class PostgresDao {

    @Autowired
    private DataSource dataSource;

    private Jdbi jdbi;

    @PostConstruct
    private void initJdbi() {

        jdbi = Jdbi.create(dataSource)
                .installPlugin(new SqlObjectPlugin())
                .installPlugin(new PostgresPlugin());

        log.info("Successfully initialized {} instance", jdbi.getClass().getSimpleName());
    }

    public void save(SampleGenerationRecord record) {

        String recordClass = record.getClass().getSimpleName();
        try {
            log.info("Saving instance of {}", recordClass);
            jdbi.useHandle(handle -> handle.attach(SampleGenerationRecordDao.class).save(record));
            log.info("Successfully saved instance of {}", recordClass);
        } catch (Exception e) {
            log.error("Caught exception while saving instance of {}. Stack trace: ", recordClass, e);
        }
    }
}
