package it.luca.data.jdbc.dto;

import it.luca.data.model.common.Dataflow;

public class SuccessfulSampleGenerationRecord extends SampleGenerationRecord {

    public SuccessfulSampleGenerationRecord(Dataflow<?> dataFlowModel) {
        super(dataFlowModel, null);
    }
}
