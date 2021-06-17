package it.luca.data.exception;

import java.lang.reflect.Field;

public class MissingDataAnnotationException extends Exception {

    public MissingDataAnnotationException(Field field) {

        super(String.format("No data annotation detected for field %s", field.getName()));
    }
}
