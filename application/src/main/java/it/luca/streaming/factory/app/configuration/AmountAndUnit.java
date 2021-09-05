package it.luca.streaming.factory.app.configuration;

import lombok.Data;

import java.time.temporal.ChronoUnit;

@Data
public class AmountAndUnit {

    private int amount;
    private ChronoUnit unit;

    public void setUnit(String unit) {
        this.unit = ChronoUnit.valueOf(unit.toUpperCase());
    }

    @Override
    public String toString() {
        return String.format("%s %s", amount, unit.name());
    }

    public long inMilliSeconds() {

        long millis;
        switch (unit) {
            case SECONDS: millis = amount * 1000; break;
            case MINUTES: millis = amount * 1000 * 60; break;
            case HOURS: millis = amount * 1000 * 60 * 60; break;
            case DAYS: millis = amount * 1000 * 60 * 60 * 24; break;
            default: throw new IllegalArgumentException(String.format("Unmatched chronoUnit: %s", unit));
        }

        return millis;
    }
}
