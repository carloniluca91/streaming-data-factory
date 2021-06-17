package it.luca.data.generator.function;

import it.luca.data.annotation.RandomDateTime;

import java.time.LocalDateTime;

public class RandomDateTimeSupplier extends DataAnnotationSupplier<RandomDateTime, LocalDateTime> {

    public RandomDateTimeSupplier(RandomDateTime annotation) {
        super(annotation);
    }

    @Override
    public LocalDateTime apply() throws Exception {
        return annotation.generator().newInstance().apply();
    }
}
