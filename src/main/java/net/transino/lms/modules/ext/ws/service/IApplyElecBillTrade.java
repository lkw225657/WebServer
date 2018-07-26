package net.transino.lms.modules.ext.ws.service;

import net.transino.lms.modules.ext.ws.server.apply.ApplyElecBillTradeRequest;
import net.transino.lms.modules.ext.ws.server.apply.ApplyElecBillTradeResponse;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * @author lee
 * @since 5.0
 */
@WebService(targetNamespace ="ws.lms.transino.net", name = "applyElecBillTradeWs")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface IApplyElecBillTrade {

    /**
     * 电票系统向信贷系统发起电票业务申请。
     * @param request 请求报文
     * @return 返回报文
     */
    @WebMethod
    @WebResult (name = "XERP")
    ApplyElecBillTradeResponse applyElecBillTrade(@WebParam(name = "XERP") ApplyElecBillTradeRequest request);
}