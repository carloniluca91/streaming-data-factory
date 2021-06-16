package it.luca.data.generator.functions;

import java.time.LocalDateTime;

public class Now extends Generator<LocalDateTime> {

    @Override
    public LocalDateTime apply() {

        return LocalDateTime.now();
    }
}
