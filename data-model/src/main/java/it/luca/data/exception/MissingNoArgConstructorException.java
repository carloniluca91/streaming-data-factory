package it.luca.data.exception;

public class MissingNoArgConstructorException extends Exception {

    public MissingNoArgConstructorException(Class<?> clazz) {

        super(String.format("Unable to find a no-arg constructor for class %s", clazz.getName()));
    }
}
