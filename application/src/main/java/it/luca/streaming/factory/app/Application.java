package it.luca.streaming.factory.app;

import it.luca.streaming.factory.app.controller.DataflowController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@Slf4j
@SpringBootApplication
public class Application implements ApplicationRunner {

    @Value("${flows}")
    private List<String> dataflows;

    @Autowired
    private DataflowController controller;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws InterruptedException {

        log.info("Found {} dataflow(s) to trigger ({})", dataflows.size(), String.join(", ", dataflows));
        controller.run(dataflows);
    }
}

