package it.luca.data.service;

import it.luca.data.model.common.Dataflow;
import it.luca.data.generator.pojo.PojoGenerator;
import it.luca.data.jdbc.dao.PostgresDao;
import it.luca.data.jdbc.dto.FailedSampleGenerationRecord;
import it.luca.data.jdbc.dto.SampleGenerationRecord;
import it.luca.data.jdbc.dto.SuccessfulSampleGenerationRecord;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SenderService {

    @Autowired
    private PostgresDao dao;

    public <T> void sendDataFor(Dataflow<T> dataFlow) {

        SampleGenerationRecord sampleGenerationRecord;
        String dataFlowId = dataFlow.getId();
        try {
            log.info("Starting to generate random instance for dataFlow {}", dataFlowId);
            T instance = PojoGenerator.generate(dataFlow.getClassName());
            log.info("Successfully generated random instance for dataFlow {}", dataFlowId);
            sampleGenerationRecord = new SuccessfulSampleGenerationRecord(dataFlow);
        } catch (Exception e) {
            log.error("Caught exception while generating|sending data for dataFlow {}. Stack trace: ", dataFlowId, e);
            sampleGenerationRecord = new FailedSampleGenerationRecord(dataFlow, e);
        }

        dao.save(sampleGenerationRecord);
    }
}
