package it.luca.streaming.factory.app.configuration;

import lombok.Data;

@Data
public class SleepTime {

    private AmountAndUnit beforeSend;
    private AmountAndUnit afterSend;
}
