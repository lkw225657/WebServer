package net.transino.lms.modules.ext.ws;

import jodd.util.StringUtil;
import jodd.vtor.Violation;
import jodd.vtor.Vtor;

import javax.xml.bind.annotation.XmlTransient;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lee
 * @since 5.0
 */
@XmlTransient
public abstract class DefaultWsMessage<T extends DefaultWsBody<E>, E> implements WsMessage<E> {
    private Vtor vtor = new Vtor();
    protected T body;
    public abstract T getBody();
    public abstract void setBody(T value);

    public abstract String getProfiles();

    public boolean hasViolations() {
        if (this.getProfiles() != null){
            this.vtor.useProfiles("5000", this.getProfiles());
        }
        this.vtor.validate(this.body);
        if (!this.vtor.hasViolations() && this.getBody().getRows() != null) {
            for (E item : this.getBody().getRows()) {
                this.vtor.validate(item);
            }
        }
        return this.vtor.hasViolations();
    }

    public List<String> errors(){
        List<String> list = null;
        if (this.vtor.hasViolations()){
            List<Violation> vlist = this.vtor.getViolations();
            list = new ArrayList<>(vlist.size());
            for (Violation v: vlist) {
                list.add(v.getName() + ":" + v.getInvalidValue() + " " + v.getCheck().getMessage());
            }
        }
        return list;
    }

    public String errorMessage(){
        List<String> vlist = this.errors();
        return StringUtil.join(vlist, "\n");
    }

    @Override
    public DefaultWsMessage<T,E> addBodyData(E e) {
        this.getBody().getRows().add(e);
        return this;
    }

    @Override
    public E getBodyData(int index) {
        return this.getBody().getRows().get(index);
    }

    @Override
    public int bodyDataSize() {
        return this.getBody().getRows().size();
    }
}