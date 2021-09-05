package it.luca.streaming.factory.app.jdbc.dto;

import it.luca.streaming.factory.model.Dataflow;

public class FailedSampleGenerationRecord extends SampleGenerationRecord {

    public FailedSampleGenerationRecord(Dataflow<?> dataflow, Exception exception) {

        super(dataflow, exception);
    }
}
