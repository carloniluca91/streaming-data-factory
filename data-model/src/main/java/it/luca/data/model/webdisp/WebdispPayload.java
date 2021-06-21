package it.luca.data.model.webdisp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import it.luca.data.annotation.RandomDateTime;
import it.luca.data.annotation.RandomSequence;
import it.luca.data.generator.function.Now;
import it.luca.data.model.common.DatePattern;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class WebdispPayload {

    @RandomDateTime(supplier = Now.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DatePattern.WEBDISP_DATA_ORA_INVIO)
    private LocalDateTime dataOraInvio;

    @RandomSequence(of = WebdispNomina.class, size = 4)
    private List<WebdispNomina> nomine;
}
