package it.luca.streaming.factory.model.bean.webdisp;

import it.luca.streaming.factory.model.DataflowType;
import it.luca.streaming.factory.model.bean.common.DataflowTest;

import static it.luca.utils.functional.Optional.isPresent;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WebdispPayloadTest extends DataflowTest<WebdispPayload> {

    public WebdispPayloadTest() {
        super(WebdispPayload.class, DataflowType.XML, "webdisp");
    }

    @Override
    protected void validatePojo(WebdispPayload instance) {

        assertTrue(isPresent(instance.getDataOraInvio()));
        assertTrue(isPresent(instance.getNomine()));
        assertFalse(instance.getNomine().isEmpty());
    }
}