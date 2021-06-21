package it.luca.data.model.common;

import it.luca.data.enumeration.DataFlowId;
import it.luca.data.enumeration.DataFlowType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class DataFlowModel<T> {

    private final Class<T> tClass;
    private final DataFlowId dataFlowId;
    private final DataFlowType type;
    private final String url;
}
