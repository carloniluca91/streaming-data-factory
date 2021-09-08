package it.luca.streaming.factory.model.function;

import it.luca.data.factory.generator.function.PlusOrMinusTime;
import it.luca.data.factory.generator.function.Signum;
import it.luca.data.factory.generator.function.TimeAmount;

import java.time.temporal.ChronoUnit;

import static it.luca.utils.time.Supplier.now;

public class LastClockHour extends PlusOrMinusTime {

    public LastClockHour() {
        super(Signum.MINUS, TimeAmount.of(ChronoUnit.SECONDS, now().getMinute() * 60 + now().getSecond()));
    }
}
