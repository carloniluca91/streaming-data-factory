package it.luca.data.controller;

import it.luca.data.configuration.ApplicationProperties;
import it.luca.data.model.common.Dataflow;
import it.luca.data.service.SenderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

import static it.luca.utils.functional.Stream.filter;

@Slf4j
@Component
public class DataflowRunner {

    @Autowired
    private SenderService service;

    @Autowired
    private ApplicationProperties applicationProperties;

    @SuppressWarnings("all")
    public void run(List<String> dataFlowsIds) throws InterruptedException {

        List<Dataflow<?>> dataflows = filter(applicationProperties.getDataflows(), x -> dataFlowsIds.contains(x.getId()));
        long sleepTime = applicationProperties.getSleepTimeInSeconds() * 1000;
        Random random = new Random();
        while (true) {
            Dataflow<?> dataFlowToRun = dataflows.get(random.nextInt(dataflows.size()));
            log.info("Randomly picked dataflow {}", dataFlowToRun.getId());
            service.sendDataFor(dataFlowToRun);
            log.info("Putting the circus to sleept for {} second(s)", applicationProperties.getSleepTimeInSeconds());
            Thread.sleep(sleepTime);
            log.info("Waking up the circus once again");
        }

    }
}
