package it.luca.data.model;

import it.luca.data.enumeration.DataFlowType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class DataFlowModel<T> {

    private final Class<T> tClass;
    private final DataFlowType type;
    private final String url;
}
