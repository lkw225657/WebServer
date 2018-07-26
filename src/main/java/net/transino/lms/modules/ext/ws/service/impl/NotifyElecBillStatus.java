package net.transino.lms.modules.ext.ws.service.impl;

import net.transino.lms.modules.ext.ws.server.AbstractProcessor;
import net.transino.lms.modules.ext.ws.server.WsProcessorException;
import net.transino.lms.modules.ext.ws.server.notify.NotifyElecBillStatusRequest;
import net.transino.lms.modules.ext.ws.server.notify.NotifyElecBillStatusResponse;
import net.transino.lms.modules.ext.ws.service.INotifyElecBillStatus;
import org.springframework.stereotype.Component;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * @author lee
 * @since 5.0
 */
@Component("notifyElecBillStatusWs")
@WebService(endpointInterface = "net.transino.lms.modules.ext.ws.service.INotifyElecBillStatus",
        targetNamespace = "ws.lms.transino.net", name = "notifyElecBillStatusWs")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class NotifyElecBillStatus implements INotifyElecBillStatus {

    @Override
    public NotifyElecBillStatusResponse notifyElecBillStatus(NotifyElecBillStatusRequest request) {
        String bizCode = request.getHead().getBizCode();
        NotifyElecBillStatusResponse response = new NotifyElecBillStatusResponse();
        AbstractProcessor soapProcessor = AbstractProcessor.newInstance(bizCode);
        if(soapProcessor == null){
            response.getHead().setResMsg("未知的业务代码！");
            return response;
        }
        soapProcessor.postMessage(request, response);
        return response;
    }
}