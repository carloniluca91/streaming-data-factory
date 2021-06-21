package it.luca.data.jdbc.dto;

import it.luca.data.model.common.DataflowModel;

public class SuccessfulSampleGenerationRecord extends SampleGenerationRecord {

    public SuccessfulSampleGenerationRecord(DataflowModel<?> dataFlowModel) {
        super(dataFlowModel, null);
    }
}
