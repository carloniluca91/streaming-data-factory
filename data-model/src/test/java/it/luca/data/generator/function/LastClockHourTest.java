package it.luca.data.generator.function;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static it.luca.utils.time.Supplier.now;
import static org.junit.jupiter.api.Assertions.*;

class LastClockHourTest {

    @Test
    void apply() {

        LocalDateTime now = now();
        LocalDateTime lastClockHour = new LastClockHour().apply();
        assertEquals(now.getHour(), lastClockHour.getHour());
        assertEquals(0, lastClockHour.getMinute());
    }
}