package it.luca.data.controller;

import it.luca.data.model.common.DataflowModel;
import it.luca.data.model.webdisp.WebdispflowModel;
import it.luca.data.service.SenderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class DataflowRunner {

    @Value("${dataflow.webdisp.url}")
    private String webdispUrl;

    @Autowired
    private SenderService service;

    public void run(List<String> dataFlows) throws InterruptedException {

        List<DataflowModel<?>> dataflowModels = new ArrayList<>();
        dataFlows.forEach(s -> {

            DataflowModel<?> dataFlowModel;
            switch (s) {

                case "WEBDISP": dataFlowModel = new WebdispflowModel(webdispUrl); break;
                default: throw new IllegalArgumentException();
            }

            dataflowModels.add(dataFlowModel);
        });

        service.sendDataFor(dataflowModels.get(0));
        Thread.sleep(10000);
    }
}
