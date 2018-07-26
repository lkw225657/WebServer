package net.transino.lms.modules.ext.ws.server;

import net.transino.lms.modules.ext.ws.server.notify.NotifyElecBillStatusRequest;
import net.transino.lms.modules.ext.ws.server.notify.NotifyElecBillStatusResponse;

/**
 * @author lee
 * @since 5.0
 */
public class NotifyElecBillStatusProcessor extends AbstractProcessor<NotifyElecBillStatusRequest, NotifyElecBillStatusResponse> {

    NotifyElecBillStatusProcessor(String bizCode) {
        this.bizCode = bizCode;
    }

    @Override
    protected void doProcessor(NotifyElecBillStatusRequest request, NotifyElecBillStatusResponse response) throws Exception {
        throw new WsProcessorException("9550","处理未执行");
    }
}