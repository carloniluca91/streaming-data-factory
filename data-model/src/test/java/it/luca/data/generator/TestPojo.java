package it.luca.data.generator;

import it.luca.data.annotation.RandomDateTime;
import it.luca.data.generator.functions.Now;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class TestPojo {

    @RandomDateTime(generator = Now.class)
    private LocalDateTime ts;
}
