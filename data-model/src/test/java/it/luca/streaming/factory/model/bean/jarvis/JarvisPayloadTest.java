package it.luca.streaming.factory.model.bean.jarvis;

import it.luca.streaming.factory.model.DataflowType;
import it.luca.streaming.factory.model.bean.common.DataflowTest;

import static org.junit.jupiter.api.Assertions.*;

class JarvisPayloadTest extends DataflowTest<JarvisPayload> {

    public JarvisPayloadTest() {
        super(JarvisPayload.class, DataflowType.XML, "jarvis");
    }

    @Override
    protected void validatePojo(JarvisPayload instance) {

        assertNotNull(instance.getAmbitoFlusso());
        assertNotNull(instance.getNomeFlusso());
        assertNotNull(instance.getImpresaMittente());
        assertNotNull(instance.getGiornoGas());
        assertNotNull(instance.getCicli());
        assertFalse(instance.getCicli().isEmpty());
    }
}