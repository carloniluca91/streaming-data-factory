package it.luca.data.configuration;

import it.luca.data.model.common.Dataflow;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@ConfigurationProperties(prefix = "application")
public class ApplicationProperties {

    private int sleepTimeInSeconds;

    private List<Dataflow<?>> dataflows;
}
