package it.luca.data.service;

import it.luca.data.generator.pojo.PojoSerializer;
import it.luca.data.model.DataSourceResponseDto;
import it.luca.data.model.common.Dataflow;
import it.luca.data.generator.pojo.PojoGenerator;
import it.luca.data.jdbc.dao.PostgresDao;
import it.luca.data.jdbc.dto.FailedSampleGenerationRecord;
import it.luca.data.jdbc.dto.SampleGenerationRecord;
import it.luca.data.jdbc.dto.SuccessfulSampleGenerationRecord;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class SenderService {

    @Autowired
    private PostgresDao dao;

    public <T> void sendDataFor(Dataflow<T> dataflow) {

        SampleGenerationRecord sampleGenerationRecord;
        String dataFlowId = dataflow.getId();
        try {
            log.info("Starting to generate random instance for dataflow {}", dataFlowId);
            T instance = PojoGenerator.generate(dataflow.getClassName());
            log.info("Successfully generated random instance for dataflow {}", dataFlowId);
            String serializedInstance = PojoSerializer.objToString(instance, dataflow.getType());
            RestTemplate restTemplate = new RestTemplateBuilder().build();
            DataSourceResponseDto response = restTemplate.postForObject(dataflow.getUrl(), serializedInstance, DataSourceResponseDto.class);

            // TODO: improve response printing
            log.info("Response: {}", response);
            sampleGenerationRecord = new SuccessfulSampleGenerationRecord(dataflow);
        } catch (Exception e) {
            log.error("Caught exception while generating|sending data for dataflow {}. Stack trace: ", dataFlowId, e);
            sampleGenerationRecord = new FailedSampleGenerationRecord(dataflow, e);
        }

        dao.save(sampleGenerationRecord);
    }
}
