package it.luca.data.model.webdisp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
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
@JacksonXmlRootElement(localName = "root")
public class WebdispPayload {

    @RandomDateTime(supplier = Now.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DatePattern.WEBDISP_DATA_ORA_INVIO)
    private LocalDateTime dataOraInvio;

    @RandomSequence(of = WebdispNomina.class, maxSize = 12)
    @JacksonXmlElementWrapper(localName = "nomine")
    @JacksonXmlProperty(localName = "nomina")
    private List<WebdispNomina> nomine;
}
