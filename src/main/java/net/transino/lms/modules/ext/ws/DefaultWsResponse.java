package net.transino.lms.modules.ext.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @author lee
 * @since 5.0
 */
@XmlTransient
@XmlAccessorType(XmlAccessType.NONE)
public abstract class DefaultWsResponse<T extends DefaultWsBody<E>, E> extends DefaultWsMessage<T, E> {
    public DefaultWsResponse() {
        this.head = new ResponseHead();
    }

    protected ResponseHead head;

    @XmlElement(name = "HEAD", required = true)
    public ResponseHead getHead() {
        return this.head;
    }

    public void setHead(ResponseHead value) {
        this.head = value;
    }

    @Override
    public T getBody() {
        return null;
    }

    @Override
    public void setBody(T value) {

    }

    @Override
    public String getProfiles(){
        return this.head.getBizCode();
    }
}