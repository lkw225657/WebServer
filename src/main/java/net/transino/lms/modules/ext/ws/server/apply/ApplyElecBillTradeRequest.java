package net.transino.lms.modules.ext.ws.server.apply;

import lombok.Getter;
import net.transino.lms.modules.ext.ws.DefaultWsRequest;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author lee
 * @since 5.0
 */
@XmlRootElement(name = "XERP")
@Getter
public class ApplyElecBillTradeRequest extends DefaultWsRequest<ApplyElecBillTradeRequestBody, ElecBillTrade> {
    public ApplyElecBillTradeRequest() {
        this.setBody(new ApplyElecBillTradeRequestBody());
    }

    @XmlElement(name = "BODY", required = true)
    @Override
    public ApplyElecBillTradeRequestBody getBody() {
        return this.body;
    }

    @Override
    public void setBody(ApplyElecBillTradeRequestBody value) {
        this.body = value;
    }

    @Override
    public String getProfiles(){
        return this.head.getBizCode();
    }
}