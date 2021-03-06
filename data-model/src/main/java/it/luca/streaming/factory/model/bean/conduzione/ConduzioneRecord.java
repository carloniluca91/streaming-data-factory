package it.luca.streaming.factory.model.bean.conduzione;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import it.luca.data.factory.annotation.MappedByField;
import it.luca.data.factory.annotation.RandomDateTime;
import it.luca.data.factory.annotation.RandomNumber;
import it.luca.data.factory.annotation.RandomValue;
import it.luca.data.factory.generator.function.Now;
import it.luca.streaming.factory.model.bean.DatePattern;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ConduzioneRecord {

    @RandomNumber(min = 100000, max = 1000000, as = Double.class)
    private Double vstockCor;

    @RandomNumber(min = 100000, max = 1000000, as = Double.class)
    private Double vprdn;

    @RandomNumber(min = 100000, max = 1000000, as = Double.class)
    private Double viniet;

    @RandomNumber(min = 10, max = 11, as = Double.class)
    private Double vpcsStocg;

    @RandomNumber(min = 10, max = 11, as = Double.class)
    private Double vpcsRcp;

    @RandomNumber(min = 1, max = 3, as = Integer.class)
    private Integer pver;

    @RandomNumber(min = 1, max = 13, as = Integer.class)
    private Integer qrecTot;

    @RandomDateTime(supplier = Now.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DatePattern.CONDUZIONE_DRE)
    private LocalDateTime dre;

    @RandomValue(values = {"I", "U"})
    private String tipoAggiornamento;

    @RandomValue(useClasspathLocator = true)
    private String ccmp;

    @MappedByField(fieldName = "ccmp")
    private String ncmp;

    @RandomDateTime(supplier = Now.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DatePattern.CONDUZIONE_DRIF)
    private LocalDateTime drif;

    @RandomNumber(min = 100000, max = 1000000, as = Double.class)
    private Double vcnsm;

    @RandomNumber(min = 100000, max = 1000000, as = Double.class)
    private Double vstockTot;
}
