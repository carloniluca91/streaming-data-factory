package it.luca.data.jdbc.dto;

import it.luca.data.model.common.DataFlowModel;

public class SuccessfulSampleGenerationRecord extends SampleGenerationRecord {

    public SuccessfulSampleGenerationRecord(DataFlowModel<?> dataFlowModel) {
        super(dataFlowModel, null);
    }
}
