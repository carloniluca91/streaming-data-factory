package it.luca.data.model.int002;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import it.luca.data.annotation.RandomDateTime;
import it.luca.data.annotation.RandomNumber;
import it.luca.data.generator.function.Now;
import it.luca.data.model.common.DatePattern;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Int002Ciclo {

    @RandomDateTime(supplier = Now.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DatePattern.INT002_GIORNO_ORA_RIFERIMENTO)
    private LocalDateTime giornoOraRiferimento;

    private final String uDM1 = "SMC";
    private final String uDM2 = "KWH";
    private final String uDM3 = "NMC";
    private final String uDM4 = "KWH";

    private String descrizione;

    private final String tipologia = "Entry Produzione Nazionale";

    private String codiceRemi;

    @RandomNumber(min = 100, max = 100000, as = Double.class)
    private Double valore1;

    @RandomNumber(min = 100, max = 100000, as = Double.class)
    private Double progressivo1;

    @RandomNumber(min = 100, max = 100000, as = Double.class)
    private Double valore2;

    @RandomNumber(min = 100, max = 100000, as = Double.class)
    private Double progressivo2;

    @RandomNumber(min = 10, max = 11, as = Double.class)
    private Double pcs;

    @RandomNumber(min = 100, max = 100000, as = Double.class)
    private Double valore3;

    @RandomNumber(min = 100, max = 100000, as = Double.class)
    private Double progressivo3;

    @RandomNumber(min = 100, max = 100000, as = Double.class)
    private Double valore4;

    @RandomNumber(min = 100, max = 100000, as = Double.class)
    private Double progressivo4;

    @RandomNumber(min = 10, max = 11, as = Double.class)
    private Double pcs250;

    @RandomNumber(min = 10, max = 11, as = Double.class)
    private Double wobbe2515;

    @RandomNumber(min = 10, max = 11, as = Double.class)
    private Double wobbe250;
}
