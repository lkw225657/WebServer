package net.transino.lms.modules.ext.ws;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * @author lee
 * @since 5.0
 */
@XmlTransient
public abstract class DefaultWsBody<E> {
    protected List<E> getRows(){
        return null;
    };

    protected void setRows(List<E> rows){

    };
}