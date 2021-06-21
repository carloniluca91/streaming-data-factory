package it.luca.data.jdbc.dto;

import it.luca.data.enumeration.SampleGenerationCode;
import it.luca.data.model.common.DataFlowModel;
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

    public SampleGenerationRecord(DataFlowModel<?> dataFlowModel, Exception exception) {

        this.dataflowId = dataFlowModel.getDataFlowId().name();
        this.dataflowType = dataFlowModel.getType().name();
        this.dataflowClass = dataFlowModel.getTClass().getName();
        this.dataflowUrl = dataFlowModel.getUrl();
        this.sampleGenerationCode = (isPresent(exception) ? SampleGenerationCode.KO : SampleGenerationCode.OK).name();
        this.exceptionClass = orNull(exception, x -> x.getClass().getName());
        this.exceptionMessage = orNull(exception, Throwable::getMessage);
    }
}
