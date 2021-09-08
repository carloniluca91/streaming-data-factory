package it.luca.streaming.factory.model.bean.webdisp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import it.luca.data.factory.annotation.MappedByField;
import it.luca.data.factory.annotation.RandomDateTime;
import it.luca.data.factory.annotation.RandomNumber;
import it.luca.data.factory.annotation.RandomValue;
import it.luca.streaming.factory.model.bean.DatePattern;
import it.luca.streaming.factory.model.function.LastClockHour;
import it.luca.streaming.factory.model.function.NextClockHour;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class WebdispNomina {

    private final String unitaMisuraEnergia = "KWH";

    @RandomNumber(min = 10, max = 11, as = Double.class)
    private Double pcs;

    @RandomDateTime(supplier = NextClockHour.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DatePattern.WEBDISP_DATA_DECORRENZA)
    private LocalDateTime dataDecorrenza;

    @RandomDateTime(supplier = LastClockHour.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DatePattern.WEBDISP_DATA_ELABORAZIONE)
    private LocalDateTime dataElaborazione;

    @RandomNumber(min = 10000, max = 1000000, as = Double.class)
    private Double valoreVolume;

    private final String unitaMisuraVolume = "SMC";

    @RandomNumber(min = 10000, max = 1000000, as = Double.class)
    private Double valoreEnergia;

    @RandomValue(useClasspathLocator = true)
    private String codiceRemi;

    @MappedByField(fieldName = "codiceRemi")
    private String descrizioneRemi;

    @MappedByField(fieldName = "codiceRemi")
    private String descrizionePunto;

    @RandomValue(useClasspathLocator = true)
    private String tipoNomina;

    @RandomValue(useClasspathLocator = true)
    private String cicloNomina;

    @MappedByField(fieldName = "codiceRemi")
    private String tipologiaPunto;
}
