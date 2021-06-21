package it.luca.data.generator.function;

public interface DataSupplier<T> {

    T apply() throws Exception;
}
