package it.luca.data.jdbc.dto;

import it.luca.data.enumeration.SampleGenerationCode;
import it.luca.data.model.common.Dataflow;
import lombok.Getter;

import java.sql.Date;
import java.sql.Timestamp;

import static it.luca.utils.functional.Optional.isPresent;
import static it.luca.utils.functional.Optional.orNull;
import static it.luca.utils.time.Supplier.now;

@Getter
public abstract class SampleGenerationRecord {

    private final Timestamp sampleGenerationTs = Timestamp.valueOf(now());
    private final Date sampleGenerationDt = Date.valueOf(now().toLocalDate());
    private final String dataflowId;
    private final String dataflowType;
    private final String dataflowClass;
    private final String dataflowUrl;
    private final String sampleGenerationCode;
    private final String exceptionClass;
    private final String exceptionMessage;

    public SampleGenerationRecord(Dataflow<?> dataflow, Exception exception) {

        this.dataflowId = dataflow.getId();
        this.dataflowType = dataflow.getType().name();
        this.dataflowClass = dataflow.getClassName().getName();
        this.dataflowUrl = dataflow.getUrl();
        this.sampleGenerationCode = (isPresent(exception) ? SampleGenerationCode.KO : SampleGenerationCode.OK).name();
        this.exceptionClass = orNull(exception, x -> x.getClass().getName());
        this.exceptionMessage = orNull(exception, Throwable::getMessage);
    }
}
