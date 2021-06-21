package it.luca.data.jdbc.dto;

import it.luca.data.model.common.DataFlowModel;

public class FailedSampleGenerationRecord extends SampleGenerationRecord {

    public FailedSampleGenerationRecord(DataFlowModel<?> dataFlowModel, Exception exception) {

        super(dataFlowModel, exception);
    }
}
