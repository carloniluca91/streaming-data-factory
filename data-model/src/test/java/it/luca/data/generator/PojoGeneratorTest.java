package it.luca.data.generator;

import it.luca.data.generator.pojo.PojoGenerator;
import org.junit.jupiter.api.Test;

class PojoGeneratorTest {

    @Test
    void create() throws Exception {

        TestPojo testPojo = PojoGenerator.generate(TestPojo.class);
        int a = 1;
    }

}