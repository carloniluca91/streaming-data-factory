package it.luca.streaming.factory.model.bean.int002;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import it.luca.data.factory.annotation.RandomDateTime;
import it.luca.data.factory.annotation.RandomNumber;
import it.luca.data.factory.annotation.RandomValue;
import it.luca.data.factory.generator.function.Now;
import it.luca.streaming.factory.model.bean.DatePattern;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Int002Ciclo {

    @RandomDateTime(supplier = Now.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DatePattern.INT002_GIORNO_ORA_RIFERIMENTO)
    private LocalDateTime giornoOraRiferimento;

    private final String uDM1 = "SMC";

    @JsonProperty("uDM1")
    public String getuDM1() {
        return uDM1;
    }

    private final String uDM2 = "KWH";

    @JsonProperty("uDM2")
    public String getuDM2() {
        return uDM2;
    }

    private final String uDM3 = "NMC";

    @JsonProperty("uDM3")
    public String getuDM3() {
        return uDM3;
    }

    private final String uDM4 = "KWH";

    @JsonProperty("uDM4")
    public String getuDM4() {
        return uDM4;
    }

    @RandomValue(values = {"SAN SALVO ER.", "ITAL GAS STORAGE ER.", "MAZARA", "MASERA"})
    private String descrizione;

    private final String tipologia = "Entry Produzione Nazionale";

    private final String codiceRemi = "1713307";

    @RandomNumber(min = 100, max = 100000, as = Double.class)
    private Double valore1;

    @RandomNumber(min = 100, max = 100000, as = Double.class)
    private Double progressivo1;

    @RandomNumber(min = 100, max = 100000, as = Double.class)
    private Double valore2;

    @RandomNumber(min = 100, max = 100000, as = Double.class)
    private Double progressivo2;

    @RandomNumber(min = 10, max = 11, as = Double.class)
    private Double PCS;

    @JsonProperty("PCS")
    public Double getPCS() {
        return PCS;
    }

    @RandomNumber(min = 100, max = 100000, as = Double.class)
    private Double valore3;

    @RandomNumber(min = 100, max = 100000, as = Double.class)
    private Double progressivo3;

    @RandomNumber(min = 100, max = 100000, as = Double.class)
    private Double valore4;

    @RandomNumber(min = 100, max = 100000, as = Double.class)
    private Double progressivo4;

    @RandomNumber(min = 10, max = 11, as = Double.class)
    private Double pCS250;

    @JsonProperty("pCS25_0")
    public Double getpCS250() {
        return pCS250;
    }

    @RandomNumber(min = 10, max = 11, as = Double.class)
    private Double wobbe2515;

    @JsonProperty("wobbe25_15")
    public Double getWobbe2515() {
        return wobbe2515;
    }

    @RandomNumber(min = 10, max = 11, as = Double.class)
    private Double wobbe250;

    @JsonProperty("wobbe25_0")
    public Double getWobbe250() {
        return wobbe250;
    }
}
