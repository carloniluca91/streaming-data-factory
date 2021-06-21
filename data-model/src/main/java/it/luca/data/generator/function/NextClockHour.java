package it.luca.data.generator.function;

import it.luca.data.enumeration.Signum;

import java.time.temporal.ChronoUnit;

import static it.luca.utils.time.Supplier.now;

public class NextClockHour extends PlusOrMinusTime {

    public NextClockHour() {

        super(Signum.PLUS, ((59 - now().getMinute()) * 60) + 60 - now().getSecond(), ChronoUnit.SECONDS);
    }
}
