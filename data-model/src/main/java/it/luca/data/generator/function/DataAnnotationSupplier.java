package it.luca.data.generator.function;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.lang.annotation.Annotation;

@Getter
@AllArgsConstructor
public abstract class DataAnnotationSupplier<T extends Annotation, R> {

    protected final T annotation;

    public abstract R apply() throws Exception;
}
