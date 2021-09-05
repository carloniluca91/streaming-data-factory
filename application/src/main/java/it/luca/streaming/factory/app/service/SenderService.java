package it.luca.streaming.factory.app.service;

import it.luca.data.factory.generator.bean.BeanGenerator;
import it.luca.streaming.factory.app.dto.DataSourceResponseDto;
import it.luca.streaming.factory.app.jdbc.dao.PostgresDao;
import it.luca.streaming.factory.app.jdbc.dto.FailedSampleGenerationRecord;
import it.luca.streaming.factory.app.jdbc.dto.SampleGenerationRecord;
import it.luca.streaming.factory.app.jdbc.dto.SuccessfulSampleGenerationRecord;
import it.luca.streaming.factory.model.BeanSerializer;
import it.luca.streaming.factory.model.Dataflow;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import static it.luca.utils.functional.Optional.isPresent;

@Slf4j
@Component
public class SenderService {

    @Autowired
    private PostgresDao dao;

    public <T> void sendDataFor(Dataflow<T> dataflow) {

        SampleGenerationRecord sampleGenerationRecord;
        String dataflowId = dataflow.getId();
        try {
            log.info("Starting to generate random instance for dataflow {}", dataflowId);
            T instance = BeanGenerator.generate(dataflow.getClassName());
            log.info("Successfully generated random instance for dataflow {}", dataflowId);
            String serializedInstance = BeanSerializer.objToString(instance, dataflow.getType());
            RestTemplate restTemplate = new RestTemplateBuilder().build();
            DataSourceResponseDto response = restTemplate.postForObject(dataflow.getUrl(), serializedInstance, DataSourceResponseDto.class);
            if (isPresent(response)) {
                log.info("Response for dataflow {}:\n\n{}", dataflowId, response);
            } else {
                String responseClass = DataSourceResponseDto.class.getSimpleName();
                log.warn("Unable to deserialize response from URL {} as a instance of {}", dataflow.getUrl(), responseClass);
            }

            sampleGenerationRecord = new SuccessfulSampleGenerationRecord(dataflow);
        } catch (Exception e) {
            log.error("Caught exception while generating|sending data for dataflow {}. Stack trace: ", dataflowId, e);
            sampleGenerationRecord = new FailedSampleGenerationRecord(dataflow, e);
        }

        dao.save(sampleGenerationRecord);
    }
}
