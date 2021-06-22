package it.luca.data.generator.function;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static it.luca.utils.time.Supplier.now;
import static org.junit.jupiter.api.Assertions.*;

class NextClockHourTest {

    @Test
    void apply() {

        LocalDateTime now = now();
        LocalDateTime nextClockHour = new NextClockHour().apply();
        assertEquals(now.plusHours(1).getHour(), nextClockHour.getHour());
        assertEquals(0, nextClockHour.getMinute());
    }
}