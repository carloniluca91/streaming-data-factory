package it.luca.data.generator.function;

import it.luca.data.enumeration.Signum;

import java.time.temporal.ChronoUnit;

import static it.luca.utils.time.Supplier.now;

public class LastClockHour extends PlusOrMinusTime {

    public LastClockHour() {
        super(Signum.MINUS, now().getMinute() * 60 + now().getSecond(), ChronoUnit.SECONDS);
    }
}
