package it.luca.data.model.webdisp;

import it.luca.data.enumeration.DataFlowId;
import it.luca.data.enumeration.DataFlowType;
import it.luca.data.model.common.DataFlowModel;

public class WebdispFlowModel extends DataFlowModel<WebdispPayload> {

    public WebdispFlowModel(String url) {
        super(WebdispPayload.class, DataFlowId.WEBDISP, DataFlowType.XML, url);
    }
}
