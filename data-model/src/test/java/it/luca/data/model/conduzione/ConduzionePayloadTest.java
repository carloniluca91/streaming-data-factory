package it.luca.data.model.conduzione;

import it.luca.data.enumeration.DataflowType;
import it.luca.data.model.common.DataflowTest;

import static org.junit.jupiter.api.Assertions.*;

class ConduzionePayloadTest extends DataflowTest<ConduzionePayload> {

    public ConduzionePayloadTest() {
        super(ConduzionePayload.class, DataflowType.JSON, "conduzione");
    }

    @Override
    protected void validatePojo(ConduzionePayload instance) {

        assertNotNull(instance.getRecords());
        instance.getRecords().forEach(x -> {

            assertNotNull(x.getVstockCor());
            assertNotNull(x.getVprdn());
            assertNotNull(x.getViniet());
            assertNotNull(x.getVpcsStocg());
            assertNotNull(x.getVpcsRcp());
            assertNotNull(x.getPver());
            assertNotNull(x.getQrecTot());
            assertNotNull(x.getDre());
            assertNotNull(x.getTipoAggiornamento());
            assertNotNull(x.getCcmp());
            assertNotNull(x.getNcmp());
            assertNotNull(x.getDrif());
            assertNotNull(x.getVcnsm());
            assertNotNull(x.getVstockTot());
        });
    }
}