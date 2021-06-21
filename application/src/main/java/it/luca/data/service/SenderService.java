package it.luca.data.service;

import it.luca.data.generator.pojo.PojoGenerator;
import it.luca.data.jdbc.dao.PostgresDao;
import it.luca.data.jdbc.dto.FailedSampleGenerationRecord;
import it.luca.data.jdbc.dto.SampleGenerationRecord;
import it.luca.data.jdbc.dto.SuccessfulSampleGenerationRecord;
import it.luca.data.model.common.DataFlowModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SenderService {

    @Autowired
    private PostgresDao dao;

    public <T> void sendDataFor(DataFlowModel<T> dataFlowModel) {

        SampleGenerationRecord sampleGenerationRecord;
        String dataFlowId = dataFlowModel.getDataFlowId().name();
        try {
            log.info("Starting to generate random instance for dataFlow {}", dataFlowId);
            T instance = PojoGenerator.generate(dataFlowModel.getTClass());
            log.info("Successfully generated random instance for dataFlow {}", dataFlowId);
            sampleGenerationRecord = new SuccessfulSampleGenerationRecord(dataFlowModel);
        } catch (Exception e) {
            log.error("Caught exception while generating|sending data for dataFlow {}. Stack trace: ", dataFlowId, e);
            sampleGenerationRecord = new FailedSampleGenerationRecord(dataFlowModel, e);
        }

        dao.save(sampleGenerationRecord);
    }
}
