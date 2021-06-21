package it.luca.data.jdbc.dao;

import it.luca.data.jdbc.dto.SampleGenerationRecord;
import lombok.extern.slf4j.Slf4j;
import org.jdbi.v3.core.Jdbi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Slf4j
@Component
public class PostgresDao {

    @Value("${}")
    private String jdbcUrl;

    @Value("${}")
    private String user;

    @Value("${}")
    private String password;

    @Value("${}")
    private String sampleGenerationLogTable;

    private Jdbi jdbi;

    @PostConstruct
    private void initJdbi() throws SQLException {

        Connection connection = DriverManager.getConnection(jdbcUrl, user, password);
        jdbi = Jdbi.create(connection);
        log.info("Successfully initialized {} instance", jdbi.getClass().getSimpleName());
    }

    public void save(SampleGenerationRecord record) {

        String recordClass = record.getClass().getSimpleName();
        try {
            log.info("Saving instance of {} into table {}", recordClass, sampleGenerationLogTable);
            jdbi.useHandle(handle -> handle.attach(SampleGenerationRecordDao.class).save(sampleGenerationLogTable, record));
            log.info("Successfully saved instance of {} into table {}", recordClass, sampleGenerationLogTable);
        } catch (Exception e) {
            log.error("Caught exception while saving instance of {} into table {}. Stack trace: ", recordClass, sampleGenerationLogTable, e);
        }
    }
}
