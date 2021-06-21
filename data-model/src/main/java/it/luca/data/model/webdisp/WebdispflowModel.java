package it.luca.data.model.webdisp;

import it.luca.data.enumeration.DataflowId;
import it.luca.data.enumeration.DataflowType;
import it.luca.data.model.common.DataflowModel;

public class WebdispflowModel extends DataflowModel<WebdispPayload> {

    public WebdispflowModel(String url) {
        super(WebdispPayload.class, DataflowId.WEBDISP, DataflowType.XML, url);
    }
}
