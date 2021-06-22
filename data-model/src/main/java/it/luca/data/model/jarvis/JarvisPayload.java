package it.luca.data.model.jarvis;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import it.luca.data.annotation.RandomDateTime;
import it.luca.data.annotation.RandomNumber;
import it.luca.data.annotation.RandomSequence;
import it.luca.data.generator.function.GiornoGas;
import it.luca.data.generator.function.Now;
import it.luca.data.model.common.DatePattern;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@JacksonXmlRootElement(localName = "root")
public class JarvisPayload {

    private final String ambitoFlusso = "Stoccaggio";
    private final String nomeFlusso = "INT006";
    private final String impresaMittente = "1713307";

    @RandomDateTime(supplier = Now.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DatePattern.JARVIS_DATA_DI_CREAZIONE)
    private LocalDateTime dataDiCreazione;

    @RandomNumber(min = 1, max = 15, as = Integer.class)
    private Integer numeroDati;

    @RandomDateTime(supplier = Now.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DatePattern.JARVIS_DATA_PROCEDURA)
    private LocalDateTime dataProcedura;

    @RandomDateTime(supplier = GiornoGas.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DatePattern.JARVIS_GIORNO_GAS)
    private String giornoGas;

    @RandomSequence(of = JarvisCiclo.class, maxSize = 10)
    @JacksonXmlElementWrapper(localName = "cicli")
    @JacksonXmlProperty(localName = "ciclo")
    private List<JarvisCiclo> cicli;
}