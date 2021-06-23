package it.luca.data.configuration;

import lombok.Data;

@Data
public class SleepTime {

    private AmountAndUnit beforeSend;
    private AmountAndUnit afterSend;
}
