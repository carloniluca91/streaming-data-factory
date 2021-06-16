package it.luca.data.generator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PojoGeneratorTest {

    @Test
    void create() throws Exception {

        TestPojo testPojo = PojoGenerator.generate(TestPojo.class);
        int a = 1;
    }

}