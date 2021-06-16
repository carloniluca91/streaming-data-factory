package it.luca.data.generator.functions;

import it.luca.data.generator.enumeration.Signum;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Getter
@AllArgsConstructor
public abstract class PlusOrMinusTime extends Generator<LocalDateTime> {

    protected final Signum signum;
    protected final int temporalAmount;
    protected final ChronoUnit chronoUnit;

    @Override
    public LocalDateTime apply() {

        return signum == Signum.MINUS ?
                LocalDateTime.now().minus(temporalAmount, chronoUnit) :
                LocalDateTime.now().plus(temporalAmount, chronoUnit);
    }
}
