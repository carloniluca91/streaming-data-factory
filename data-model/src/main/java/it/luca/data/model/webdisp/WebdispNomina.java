package it.luca.data.model.webdisp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import it.luca.data.annotation.RandomDateTime;
import it.luca.data.annotation.RandomNumber;
import it.luca.data.annotation.RandomValue;
import it.luca.data.generator.function.LastClockHour;
import it.luca.data.generator.function.NextClockHour;
import it.luca.data.model.common.DatePattern;
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
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DatePattern.WEBDISP_DATA_DECORRENZA)
    private LocalDateTime dataDecorrenza;

    @RandomDateTime(supplier = LastClockHour.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DatePattern.WEBDISP_DATA_ELABORAZIONE)
    private LocalDateTime dataElaborazione;

    @RandomNumber(min = 10000, max = 1000000, as = Double.class)
    private Double valoreVolume;

    private final String unitaMisuraVolume = "SMC";

    @RandomNumber(min = 10000, max = 1000000, as = Double.class)
    private Double valoreEnergia;

    @RandomValue(values = {"STENI_INJ", "STENI_WTH"})
    private String codiceRemi;

    @RandomValue(values = {"Stogit (immissione)", "Stogit (estrazione)"})
    private String descrizioneRemi;

    @RandomValue(values = {"STOGIT INIEZIONE", "STOGIT EROGAZIONE"})
    private String descrizionePunto;

    @RandomValue(values = {"PRE", "POST"})
    private String tipoNomina;

    @RandomValue(values = {"C01", "C02", "C03", "C04", "C05", "C07", "C08", "C09", "C10", "C11", "C12"})
    private String cicloNomina;

    @RandomValue(values = {"Immissione a stoccaggio", "Erogazione da stoccaggio"})
    private String tipologiaPunto;
}
