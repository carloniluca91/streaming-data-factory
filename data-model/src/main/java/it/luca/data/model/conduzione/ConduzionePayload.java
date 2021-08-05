package it.luca.data.model.conduzione;

import it.luca.data.annotation.RandomSequence;
import lombok.Data;

import java.util.List;

@Data
public class ConduzionePayload {

    @RandomSequence(of = ConduzioneRecord.class, maxSize = 20)
    private List<ConduzioneRecord> records;
}
