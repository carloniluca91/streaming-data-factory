package it.luca.streaming.factory.model.function;

import it.luca.data.factory.generator.function.PlusOrMinusTime;
import it.luca.data.factory.generator.function.Signum;
import it.luca.data.factory.generator.function.TimeAmount;

import java.time.temporal.ChronoUnit;

import static it.luca.utils.time.Supplier.now;

public class NextClockHour extends PlusOrMinusTime {

    public NextClockHour() {

        super(Signum.PLUS, TimeAmount.of(ChronoUnit.SECONDS, (59 - now().getMinute()) * 60 + 60 - now().getSecond()));
    }
}
