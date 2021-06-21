package it.luca.data.controller;

import it.luca.data.model.common.DataFlowModel;
import it.luca.data.model.webdisp.WebdispFlowModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class Controller {

    @Value("${stream.webdisp.url}")
    private String webdispUrl;

    public void run(List<String> dataFlows) {

        List<DataFlowModel<?>> dataFlowModels = new ArrayList<>();
        dataFlows.forEach(s -> {

            DataFlowModel<?> dataFlowModel;
            switch (s) {

                case "WEBDISP": dataFlowModel = new WebdispFlowModel(webdispUrl); break;
                default: throw new IllegalArgumentException();
            }

            dataFlowModels.add(dataFlowModel);
        });


    }
}
