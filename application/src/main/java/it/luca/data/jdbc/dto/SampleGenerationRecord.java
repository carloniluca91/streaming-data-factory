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
    private final String dataFlowId;
    private final String dataFlowType;
    private final String dataFlowClass;
    private final String dataFlowUrl;
    private final String sampleGenerationCode;
    private final String exceptionClass;
    private final String exceptionMessage;
    private final Timestamp insertTs = Timestamp.valueOf(now());
    private final Date insertDt = Date.valueOf(now().toLocalDate());

    public SampleGenerationRecord(DataFlowModel<?> dataFlowModel, Exception exception) {

        this.dataFlowId = dataFlowModel.getDataFlowId().name();
        this.dataFlowType = dataFlowModel.getType().name();
        this.dataFlowClass = dataFlowModel.getTClass().getName();
        this.dataFlowUrl = dataFlowModel.getUrl();
        this.sampleGenerationCode = (isPresent(exception) ? SampleGenerationCode.KO : SampleGenerationCode.OK).name();
        this.exceptionClass = orNull(exception, x -> x.getClass().getName());
        this.exceptionMessage = orNull(exception, Throwable::getMessage);
    }
}
