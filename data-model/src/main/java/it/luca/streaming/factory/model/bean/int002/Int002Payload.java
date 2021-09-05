package it.luca.streaming.factory.model.bean.int002;

import it.luca.data.factory.annotation.RandomSequence;
import lombok.Data;

import java.util.List;

@Data
public class Int002Payload {

    @RandomSequence(of = Int002Ciclo.class, maxSize = 50)
    private List<Int002Ciclo> cicli;
}
