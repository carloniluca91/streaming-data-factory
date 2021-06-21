package it.luca.data.jdbc.dto;

import it.luca.data.model.common.DataflowModel;

public class FailedSampleGenerationRecord extends SampleGenerationRecord {

    public FailedSampleGenerationRecord(DataflowModel<?> dataFlowModel, Exception exception) {

        super(dataFlowModel, exception);
    }
}
