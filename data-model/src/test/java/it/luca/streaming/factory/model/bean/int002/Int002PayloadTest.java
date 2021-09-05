package it.luca.streaming.factory.model.bean.int002;

import it.luca.streaming.factory.model.DataflowType;
import it.luca.streaming.factory.model.bean.common.DataflowTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class Int002PayloadTest extends DataflowTest<Int002Payload> {

    public Int002PayloadTest() {
        super(Int002Payload.class, DataflowType.JSON, "int002");
    }

    @Override
    protected void validatePojo(Int002Payload instance) {

        assertNotNull(instance.getCicli());
        instance.getCicli().forEach(int002Ciclo -> {

            assertNotNull(int002Ciclo.getGiornoOraRiferimento());
            assertNotNull(int002Ciclo.getuDM1());
            assertNotNull(int002Ciclo.getuDM2());
            assertNotNull(int002Ciclo.getuDM3());
            assertNotNull(int002Ciclo.getuDM4());
            assertNotNull(int002Ciclo.getDescrizione());
            assertNotNull(int002Ciclo.getTipologia());
            assertNotNull(int002Ciclo.getCodiceRemi());
            assertNotNull(int002Ciclo.getValore1());
            assertNotNull(int002Ciclo.getProgressivo1());
            assertNotNull(int002Ciclo.getValore2());
            assertNotNull(int002Ciclo.getProgressivo2());
            assertNotNull(int002Ciclo.getPCS());
            assertNotNull(int002Ciclo.getValore3());
            assertNotNull(int002Ciclo.getProgressivo3());
            assertNotNull(int002Ciclo.getValore4());
            assertNotNull(int002Ciclo.getProgressivo4());
            assertNotNull(int002Ciclo.getpCS250());
            assertNotNull(int002Ciclo.getWobbe2515());
            assertNotNull(int002Ciclo.getWobbe250());
        });
    }
}
