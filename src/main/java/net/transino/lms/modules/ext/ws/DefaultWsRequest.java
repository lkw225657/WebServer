package net.transino.lms.modules.ext.ws;

import javax.xml.bind.annotation.*;
import com.alibaba.fastjson.JSON;
/**
 * @author lee
 * @since 5.0
 */
@XmlTransient
public abstract class DefaultWsRequest<T extends DefaultWsBody<E>, E> extends DefaultWsMessage<T, E> {
    public DefaultWsRequest() {
        this.head = new RequestHead();
    }

    protected RequestHead head;

    @XmlElement(name = "HEAD", required = true)
    public RequestHead getHead() {
        return this.head;
    }

    public void setHead(RequestHead value) {
        this.head = value;
    }

    @Override
    public String getProfiles(){
        return null;
    }

    public String toJSONString(){
        return JSON.toJSONString(this.getBody());
    }
}