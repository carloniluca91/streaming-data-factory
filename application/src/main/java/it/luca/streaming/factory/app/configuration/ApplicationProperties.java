package it.luca.streaming.factory.app.configuration;

import it.luca.streaming.factory.model.Dataflow;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@ConfigurationProperties(prefix = "application")
public class ApplicationProperties {

    private SleepTime sleepTime;

    private List<Dataflow<?>> dataflows;
}
