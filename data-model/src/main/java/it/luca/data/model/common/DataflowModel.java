package it.luca.data.model.common;

import it.luca.data.enumeration.DataflowId;
import it.luca.data.enumeration.DataflowType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class DataflowModel<T> {

    private final Class<T> tClass;
    private final DataflowId dataFlowId;
    private final DataflowType type;
    private final String url;
}
