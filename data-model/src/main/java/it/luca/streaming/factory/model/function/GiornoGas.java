package it.luca.streaming.factory.model.function;

import it.luca.data.factory.generator.function.DataSupplier;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import static it.luca.utils.time.Supplier.now;

public class GiornoGas implements DataSupplier<LocalDateTime> {

    @Override
    public LocalDateTime apply() {

        ZoneId romeZoneId = ZoneId.of("Europe/Rome");
        ZonedDateTime nowAtRome = ZonedDateTime.of(now(), romeZoneId);
        ZonedDateTime dstNormalizedDateTime = romeZoneId.getRules().isDaylightSavings(nowAtRome.toInstant()) ?
                nowAtRome.minusHours(1) :
                nowAtRome;

        return (dstNormalizedDateTime.getHour() < 6 ?
                dstNormalizedDateTime.minusDays(1) :
                dstNormalizedDateTime)
                .toLocalDateTime();
    }
}
