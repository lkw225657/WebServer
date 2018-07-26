package net.transino.lms.modules.ext.ws;

/**
 * @author lee
 * @since 5.0
 */
public interface WsMessage<E> {
    WsMessage<E> addBodyData(E e);

    E getBodyData(int index);

    int bodyDataSize();
}