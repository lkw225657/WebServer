package net.transino.lms.modules.ext.ws.service;

import net.transino.lms.modules.ext.ws.server.notify.NotifyElecBillStatusRequest;
import net.transino.lms.modules.ext.ws.server.notify.NotifyElecBillStatusResponse;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * @author lee
 * @since 5.0
 */
@WebService(targetNamespace ="ws.lms.transino.net", name = "notifyElecBillStatusWs")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface INotifyElecBillStatus {

    /**
     * 电票系统向信贷系统发起电票状态变更通知。
     * @param request 请求报文
     * @return 返回报文
     */
    @WebResult(name = "XERP")
    NotifyElecBillStatusResponse notifyElecBillStatus(@WebParam(name = "XERP") NotifyElecBillStatusRequest request);
}