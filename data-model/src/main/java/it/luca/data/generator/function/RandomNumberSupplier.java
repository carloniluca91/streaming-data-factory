package it.luca.data.generator.function;

import it.luca.data.annotation.RandomNumber;

public class RandomNumberSupplier extends DataAnnotationSupplier<RandomNumber, Number> {

    public RandomNumberSupplier(RandomNumber annotation) {
        super(annotation);
    }

    @Override
    public Number apply() {

        int delta = annotation.max() - annotation.min();
        return annotation.as().cast(annotation.min() + (delta * Math.random()));
    }
}
