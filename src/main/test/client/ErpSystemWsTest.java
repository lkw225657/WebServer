package client;

import net.transino.lms.modules.ext.ws.server.apply.ApplyElecBillTradeRequest;
import net.transino.lms.modules.ext.ws.server.apply.ApplyElecBillTradeResponse;
import net.transino.lms.modules.ext.ws.server.apply.ElecBillTrade;
import net.transino.lms.modules.ext.ws.server.notify.ElecBillStatus;
import net.transino.lms.modules.ext.ws.server.notify.NotifyElecBillStatusRequest;
import net.transino.lms.modules.ext.ws.server.notify.NotifyElecBillStatusResponse;
import net.transino.lms.modules.ext.ws.service.IApplyElecBillTrade;
import net.transino.lms.modules.ext.ws.service.INotifyElecBillStatus;
import org.junit.Test;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author lee
 * @since  5.0
 */
public class ErpSystemWsTest {

    @Test
    public void notifyElecBillStatusTest(){
        String wsdl = "http://11.6.5.130:8090/webservices/notifyElecBillStatusWs?wsdl";
        String localPart = "NotifyElecBillStatusService";

        notifyElecBillStatus(wsdl, localPart);
    }

    @Test
    public void notifyElecBillStatusTest_13(){
        String wsdl = "http://11.6.8.13:8812/ws/webservices/notifyElecBillStatusWs?wsdl";
        String localPart = "NotifyElecBillStatusService";

        notifyElecBillStatus(wsdl, localPart);
    }

    @Test
    public void applyElecBillTradeTest(){
        String wsdl = "http://11.6.5.130:8090/webservices/applyElecBillTradeWs?wsdl";
        String localPart = "ApplyElecBillTradeService";

        applyElecBillTrade(wsdl, localPart);
    }

    @Test
    public void applyElecBillTradeTest_13(){
        String wsdl = "http://11.6.8.13:8812/ws/webservices/applyElecBillTradeWs?wsdl";
        String localPart = "ApplyElecBillTradeService";

        applyElecBillTrade(wsdl, localPart);
    }

    private void notifyElecBillStatus(String wsdl, String localPart) {
        URL url = null;
        try {
            url = new URL(wsdl);
        } catch (MalformedURLException e) {

        }

        //创建服务名称
        //1.namespaceURI - 命名空间地址
        //2.localPart - 服务视图名
        QName qname = new QName("ws.lms.transino.net", localPart);

        //创建服务视图
        //参数解释：
        //1.wsdlDocumentLocation - wsdl地址
        //2.serviceName - 服务名称
        Service service = Service.create(url, qname);
        //获取服务实现类
        INotifyElecBillStatus ws = service.getPort(INotifyElecBillStatus.class);
        //调用查询方法
        NotifyElecBillStatusRequest ret = new NotifyElecBillStatusRequest();
        ret.getHead().setBizCode("5210");
        ret.getHead().setBatchNo("DEF");
        ret.getBody().setElecSum(10000.0);
        ret.getBody().setAppDate("2018-07-07");
        ret.getBody().setElecCount(1);
        ret.getBody().setElecBatchId("5210");
        ElecBillStatus info = new ElecBillStatus();
        info.setAccepNo("0001");
        info.setElecId("0002");
        info.setElecBatchId("5210");
        info.setElecStatus("1");
        info.setTradeType("2");
        ret.addBodyData(info);

        NotifyElecBillStatusResponse res = ws.notifyElecBillStatus(ret);

        System.out.println(res.getHead().getBizCode());
        System.out.println(res.getHead().getResCode());
        System.out.println(res.getHead().getResMsg());
    }

    private void applyElecBillTrade(String wsdl, String localPart) {
        URL url = null;
        try {
            url = new URL(wsdl);
        } catch (MalformedURLException e) {

        }

        //创建服务名称
        //1.namespaceURI - 命名空间地址
        //2.localPart - 服务视图名
        QName qname = new QName("ws.lms.transino.net", localPart);

        //创建服务视图
        //参数解释：
        //1.wsdlDocumentLocation - wsdl地址
        //2.serviceName - 服务名称
        Service service = Service.create(url, qname);

        //获取服务实现类
        IApplyElecBillTrade ws = service.getPort(IApplyElecBillTrade.class);
        //调用查询方法
        ApplyElecBillTradeRequest ret = new ApplyElecBillTradeRequest();
        ret.getHead().setBizCode("5206");
        ret.getHead().setBatchNo("DEF");
        ElecBillTrade info = new ElecBillTrade();
//        info.setAppDate(String.format("%tD", new Date()));
//        info.setIssueDate(String.format("%tF", new Date()));
//        info.setAccepAmount(1.1);
        info.setPayeeIdType("123");
        ret.addBodyData(info);
        ret.getBody().setElecBatchId("333");
        ret.getBody().setElecCount(10);
        ret.getBody().setAppDate("2018-04-12");
        ret.getBody().setElecSum(12345.0);
        ret.getBody().setDueDate("2018-04-12");
        ret.getBody().setDiscIr(1.2);


        ApplyElecBillTradeResponse res = ws.applyElecBillTrade(ret);

        System.out.println(res.getHead().getBizCode());
        System.out.println(res.getHead().getResCode());
        System.out.println(res.getHead().getResMsg());
    }

}