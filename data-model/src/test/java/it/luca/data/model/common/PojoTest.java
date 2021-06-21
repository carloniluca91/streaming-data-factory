package it.luca.data.model.common;

import it.luca.data.generator.pojo.PojoGenerator;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@AllArgsConstructor
public abstract class PojoTest<T> {

    private final Class<T> tClass;

    @Test
    void generate() throws Exception {

        assertDoesNotThrow(() -> PojoGenerator.generate(tClass));
        T instance = PojoGenerator.generate(tClass);
        validatePojo(instance);
    }

    protected abstract void validatePojo(T instance);
}