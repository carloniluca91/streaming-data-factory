package it.luca.data.jdbc.dto;

import it.luca.data.model.common.Dataflow;

public class FailedSampleGenerationRecord extends SampleGenerationRecord {

    public FailedSampleGenerationRecord(Dataflow<?> dataflow, Exception exception) {

        super(dataflow, exception);
    }
}
