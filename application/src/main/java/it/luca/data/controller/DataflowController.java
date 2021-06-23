package it.luca.data.controller;

import it.luca.data.configuration.AmountAndUnit;
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
public class DataflowController {

    @Autowired
    private SenderService service;

    @Autowired
    private ApplicationProperties applicationProperties;

    @SuppressWarnings("all")
    public void run(List<String> dataFlowsIds) throws InterruptedException {

        Random random = new Random();
        List<Dataflow<?>> dataflows = filter(applicationProperties.getDataflows(), x -> dataFlowsIds.contains(x.getId()));
        AmountAndUnit beforeSend = applicationProperties.getSleepTime().getBeforeSend();
        AmountAndUnit afterSend = applicationProperties.getSleepTime().getAfterSend();
        while (true) {
            Dataflow<?> dataFlowToRun = dataflows.get(random.nextInt(dataflows.size()));
            log.info("Randomly picked dataflow {}. Waiting for beforeSend sleep time to end ({})", dataFlowToRun.getId(), beforeSend);
            Thread.sleep(beforeSend.inMilliSeconds());
            service.sendDataFor(dataFlowToRun);
            log.info("Waiting for afterSend sleep time to end ({})", afterSend);
            Thread.sleep(afterSend.inMilliSeconds());
            log.info("Waking up the circus once again");
        }
    }
}
