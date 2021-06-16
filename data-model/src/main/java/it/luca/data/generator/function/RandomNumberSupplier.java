package it.luca.data.generator.function;

import it.luca.data.annotation.RandomNumber;

public class RandomNumberSupplier extends DataAnnotationSupplier<RandomNumber, Double> {

    public RandomNumberSupplier(RandomNumber annotation) {
        super(annotation);
    }

    @Override
    public Double apply() {

        int delta = annotation.max() - annotation.min();
        return annotation.min() + (delta * Math.random());
    }
}
