package it.luca.streaming.factory.model;

import lombok.Data;

@Data
public class Dataflow<T> {

    private Class<T> className;
    private String id;
    private String url;
    private DataflowType type;

    @SuppressWarnings("unchecked")
    public void setClassName(String className) throws ClassNotFoundException {

        this.className = (Class<T>) Class.forName(className);
    }

    public void setType(String type) {

        this.type = DataflowType.valueOf(type.toUpperCase());
    }
}
