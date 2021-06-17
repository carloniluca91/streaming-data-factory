package it.luca.data.controller;

import it.luca.data.model.DataFlowModel;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class Controller {

    private final List<String> dataFlows;

    public void run() {

        List<DataFlowModel<?>> dataFlowModels = new ArrayList<>();
        dataFlows.forEach(s -> {

            DataFlowModel<?> dataFlowModel;
            switch (s) {

                case "WEBDISP": dataFlowModel = null; break;
                default: throw new IllegalArgumentException();
            }

            dataFlowModels.add(dataFlowModel);
        });


    }
}
