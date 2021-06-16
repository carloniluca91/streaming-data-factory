package it.luca.data.generator.function;

import java.time.LocalDateTime;

public class Now extends DataSupplier<LocalDateTime> {

    @Override
    public LocalDateTime apply() {

        return LocalDateTime.now();
    }
}
