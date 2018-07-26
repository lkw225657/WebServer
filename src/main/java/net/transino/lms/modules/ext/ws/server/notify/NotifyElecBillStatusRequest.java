package net.transino.lms.modules.ext.ws.server.notify;

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
public class NotifyElecBillStatusRequest extends DefaultWsRequest<NotifyElecBillStatusRequestBody, ElecBillStatus> {
    public NotifyElecBillStatusRequest() {
        this.setBody(new NotifyElecBillStatusRequestBody());
    }

    @XmlElement(name = "BODY", required = true)
    @Override
    public NotifyElecBillStatusRequestBody getBody() {
        return this.body;
    }

    @Override
    public void setBody(NotifyElecBillStatusRequestBody value) {
        this.body = value;
    }

}