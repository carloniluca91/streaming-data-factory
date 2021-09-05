package it.luca.streaming.factory.app.jdbc.dto;

import it.luca.streaming.factory.model.Dataflow;

public class SuccessfulSampleGenerationRecord extends SampleGenerationRecord {

    public SuccessfulSampleGenerationRecord(Dataflow<?> dataFlowModel) {
        super(dataFlowModel, null);
    }
}
