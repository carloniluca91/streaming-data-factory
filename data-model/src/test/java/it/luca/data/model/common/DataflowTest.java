package it.luca.data.model.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import it.luca.data.enumeration.DataflowType;
import it.luca.data.generator.pojo.PojoGenerator;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@AllArgsConstructor
public abstract class DataflowTest<T> {

    private final Class<T> tClass;
    private final DataflowType dataflowType;
    private final String sampleFileName;
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final XmlMapper xmlMapper = new XmlMapper();

    @Test
    void generate() throws Exception {

        assertDoesNotThrow(() -> PojoGenerator.generate(tClass));
        T instance = PojoGenerator.generate(tClass);
        validatePojo(instance);

        if (dataflowType == DataflowType.JSON) {
            String fileName = String.format("%s.json", sampleFileName);
            objectMapper.writerWithDefaultPrettyPrinter()
                    .writeValue(Paths.get("src", "test", "resources", "samples", fileName).toFile(), instance);
        } else {
            String fileName = String.format("%s.xml", sampleFileName);
            xmlMapper.writerWithDefaultPrettyPrinter()
                    .writeValue(Paths.get("src", "test", "resources", "samples", fileName).toFile(), instance);
        }
    }

    protected abstract void validatePojo(T instance);
}