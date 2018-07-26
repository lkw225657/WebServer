package net.transino.lms.modules.ext.ws.service.impl;

import net.transino.lms.modules.ext.ws.server.AbstractProcessor;
import net.transino.lms.modules.ext.ws.server.WsProcessorException;
import net.transino.lms.modules.ext.ws.server.apply.ApplyElecBillTradeRequest;
import net.transino.lms.modules.ext.ws.server.apply.ApplyElecBillTradeResponse;
import net.transino.lms.modules.ext.ws.service.IApplyElecBillTrade;
import org.springframework.stereotype.Component;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.WebServiceException;

/**
 * @author lee
 * @since 5.0
 */
@Component("applyElecBillTradeWs")
@WebService(endpointInterface = "net.transino.lms.modules.ext.ws.service.IApplyElecBillTrade",
        targetNamespace = "ws.lms.transino.net", name = "applyElecBillTradeWs")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class ApplyElecBillTrade implements IApplyElecBillTrade {

    @Override
    public ApplyElecBillTradeResponse applyElecBillTrade(ApplyElecBillTradeRequest request) {
        String bizCode = request.getHead().getBizCode();
        ApplyElecBillTradeResponse response = new ApplyElecBillTradeResponse();
        AbstractProcessor soapProcessor = AbstractProcessor.newInstance(bizCode);
        if(soapProcessor == null){
            response.getHead().setResMsg("未知的业务代码！");
            return response;
        }
        soapProcessor.postMessage(request, response);
        return response;
    }
}