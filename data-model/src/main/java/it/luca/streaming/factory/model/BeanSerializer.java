package it.luca.streaming.factory.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BeanSerializer {

    private static final ObjectWriter jsonWriter = new ObjectMapper()
            .writerWithDefaultPrettyPrinter();

    private static final ObjectWriter xmlWriter = new XmlMapper()
            .writerWithDefaultPrettyPrinter();

    public static <T> String objToString(T instance, DataflowType dataflowType) throws JsonProcessingException {

        String tClass = instance.getClass().getSimpleName();
        log.info("Serializing instance of {} as {} string", tClass, dataflowType);
        String output = dataflowType == DataflowType.JSON ?
                jsonWriter.writeValueAsString(instance) :
                xmlWriter.writeValueAsString(instance);

        log.info("Successfully serialized instance of {} as {} string", tClass, dataflowType);
        return output;
    }

    public static <T> void writeAsFile(T instance, DataflowType dataflowType) throws JsonProcessingException {

        String tClass = instance.getClass().getSimpleName();
        log.info("Serializing instance of {} as {} string", tClass, dataflowType);
        String output = dataflowType == DataflowType.JSON ?
                jsonWriter.writeValueAsString(instance) :
                xmlWriter.writeValueAsString(instance);

        log.info("Successfully serialized instance of {} as {} string", tClass, dataflowType);
    }
}
