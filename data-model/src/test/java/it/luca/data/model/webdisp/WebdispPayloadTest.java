package it.luca.data.model.webdisp;

import it.luca.data.model.common.PojoTest;

import static it.luca.utils.functional.Optional.isPresent;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WebdispPayloadTest extends PojoTest<WebdispPayload> {

    public WebdispPayloadTest() {
        super(WebdispPayload.class);
    }

    @Override
    protected void validatePojo(WebdispPayload instance) {

        assertTrue(isPresent(instance.getDataOraInvio()));
        assertTrue(isPresent(instance.getNomine()));
        assertFalse(instance.getNomine().isEmpty());
    }
}