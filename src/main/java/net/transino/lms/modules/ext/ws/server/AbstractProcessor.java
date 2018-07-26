package net.transino.lms.modules.ext.ws.server;

import lombok.extern.slf4j.Slf4j;
import net.transino.lms.modules.ext.ws.DefaultWsRequest;
import net.transino.lms.modules.ext.ws.DefaultWsResponse;
import net.transino.lms.modules.ext.ws.util.JAXBTools;

import javax.xml.bind.JAXBException;

/**
 * @author lee
 * @since 5.0
 */
@Slf4j
public abstract class AbstractProcessor<REQ extends DefaultWsRequest, RESP extends DefaultWsResponse> {
    /**
     * 业务代码
     */
    String bizCode;

    public void postMessage(REQ request, RESP response){
        String resMsg = "";
        String resCode = "0000";
        String bizCode = request.getHead().getBizCode();

        try {
            log.info("接收报文内容：{}", this.java2Xml(request.getClass(), request));
            if (request.hasViolations()) {
                log.info("报文内容校验错误！");
                resMsg = request.errorMessage();
                resCode = "9430";
            } else {
                response.getHead().setBizCode(bizCode);
                response.getHead().setResMsg(resMsg);
                response.getHead().setResCode(resCode);
                this.doProcessor(request, response);
                log.info("返回报文内容：{}", this.java2Xml(response.getClass(), response));
                return;
            }
        } catch (WsProcessorException wse){
            wse.printStackTrace();
            resCode = wse.getMessageCode();
            resMsg = wse.getLocalizedMessage();
        }catch (Exception e){
            e.printStackTrace();
            resCode = "9500";
            resMsg = "服务器内部错误！";
        }
        response.getHead().setBizCode(bizCode);
        response.getHead().setResMsg(resMsg);
        response.getHead().setResCode(resCode);
        log.info("返回报文内容：{}", this.java2Xml(response.getClass(), response));
    }

    /**
     * 处理请求内容
     * @param request 请求内容
     * @return 处理结果
     */
    protected abstract void doProcessor(REQ request, RESP response) throws Exception;

    /**
     * 返回SOAP处理实例
     * @param bizCode 业务代码
     * @return 处理实例
     */
    public static AbstractProcessor newInstance(String bizCode) {
        AbstractProcessor processor = null;
        switch (bizCode){
            case "5204":
            case "5205":
            case "5206":
                processor = new ApplyElecBillTradeProcessor(bizCode);
                break;
            case "5207":
            case "5208":
            case "5209":
            case "5210":
            case "5211":
                processor = new NotifyElecBillStatusProcessor(bizCode);
                break;
            default:
                return null;
        }
        return processor;
    }

    private <T> String java2Xml(Class<T> cls,Object obj){
        String xml = "<JAXBException>";
        try {
            xml = JAXBTools.java2Xml(cls, obj);
        } catch (JAXBException e) {
            xml = xml + e.getErrorCode() + ":" + e.getLocalizedMessage() + "</JAXBException>";
        }
        return xml;
    }
}