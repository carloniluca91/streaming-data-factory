package it.luca.data.model.jarvis;

import it.luca.data.enumeration.DataflowType;
import it.luca.data.model.common.DataflowTest;

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