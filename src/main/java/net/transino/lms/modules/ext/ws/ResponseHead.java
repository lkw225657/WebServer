package net.transino.lms.modules.ext.ws;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author lee
 * @since 5.0
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
@Getter
@Setter
@ToString
public class ResponseHead {
    /**
     * 业务代码
     */
    @XmlElement(name = "BIZCODE")
    protected String bizCode;
    /**
     * 通讯成功代码
     */
    @XmlElement(name = "RES_CODE")
    protected String resCode;
    /**
     * 通讯返回信息
     */
    @XmlElement(name = "RES_MSG")
    protected String resMsg;
}