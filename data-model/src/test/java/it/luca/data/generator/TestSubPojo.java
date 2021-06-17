package it.luca.data.generator;

import it.luca.data.annotation.RandomDateTime;
import it.luca.data.annotation.RandomNumber;
import it.luca.data.generator.function.Now;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class TestSubPojo {

    @RandomNumber(min = 0, max = 10, outClass = Double.class)
    private Double amount;

    @RandomDateTime(generator = Now.class)
    private LocalDateTime now;
}
