package it.luca.streaming.factory.model.bean.webdisp;

import it.luca.streaming.factory.model.DataflowType;
import it.luca.streaming.factory.model.bean.common.DataflowTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class WebdispPayloadTest extends DataflowTest<WebdispPayload> {

    public WebdispPayloadTest() {
        super(WebdispPayload.class, DataflowType.XML, "webdisp");
    }

    @Override
    protected void validatePojo(WebdispPayload instance) {

        assertNotNull(instance.getDataOraInvio());
        assertNotNull(instance.getNomine());
        assertFalse(instance.getNomine().isEmpty());
        instance.getNomine().forEach(x -> {

            assertNotNull(x.getUnitaMisuraEnergia());
            assertNotNull(x.getPcs());
            assertNotNull(x.getDataDecorrenza());
            assertNotNull(x.getDataElaborazione());
            assertNotNull(x.getValoreVolume());
            assertNotNull(x.getUnitaMisuraVolume());
            assertNotNull(x.getValoreEnergia());
            assertNotNull(x.getCodiceRemi());
            assertNotNull(x.getDescrizioneRemi());
            assertNotNull(x.getDescrizionePunto());
            assertNotNull(x.getTipoNomina());
            assertNotNull(x.getCicloNomina());
            assertNotNull(x.getTipologiaPunto());
        });
    }
}