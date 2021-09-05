package it.luca.streaming.factory.model.bean.conduzione;

import it.luca.data.factory.annotation.RandomSequence;
import lombok.Data;

import java.util.List;

@Data
public class ConduzionePayload {

    @RandomSequence(of = ConduzioneRecord.class, maxSize = 20)
    private List<ConduzioneRecord> records;
}
