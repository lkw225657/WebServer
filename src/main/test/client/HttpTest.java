package client;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
//import org.codehaus.xfire.XFireFactory;
//import org.codehaus.xfire.client.XFireProxyFactory;
//import org.codehaus.xfire.service.Service;
//import org.codehaus.xfire.service.binding.ObjectServiceFactory;
import org.junit.Test;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

/**
 * @author lee
 * @since 5.0
 */
@Slf4j
public class HttpTest {
    @Test
    public void ApplyTest(){
        String url = "http://localhost:8090/webservices/applyElecBillTradeWs";
        String params = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/ext/envelope/\" xmlns:ws=\"ws.lms.transino.net\">\n" +
                "   <soapenv:Header/>\n" +
                "   <soapenv:Body>\n" +
                "      <ws:applyElecBillTrade>\n" +
                "         <XERP>\n" +
                "            <!--Optional:-->\n" +
                "            <HEAD>\n" +
                "               <!--Optional:-->\n" +
                "               <batchNo>?</batchNo>\n" +
                "               <!--Optional:-->\n" +
                "               <bizCode>?</bizCode>\n" +
                "            </HEAD>\n" +
                "            <!--Optional:-->\n" +
                "            <BODY>\n" +
                "               <!--Optional:-->\n" +
                "               <DETAIL>\n" +
                "                  <!--Zero or more repetitions:-->\n" +
                "                  <ROW>\n" +
                "                     <accepAmount>?</accepAmount>\n" +
                "                     <!--Optional:-->\n" +
                "                     <accepCurrType>?</accepCurrType>\n" +
                "                     <!--Optional:-->\n" +
                "                     <accepDielType>?</accepDielType>\n" +
                "                     <!--Optional:-->\n" +
                "                     <accepNo>?</accepNo>\n" +
                "                     <!--Optional:-->\n" +
                "                     <appDate>?</appDate>\n" +
                "                     <!--Optional:-->\n" +
                "                     <bown>?</bown>\n" +
                "                     <!--Optional:-->\n" +
                "                     <draweeAddress>?</draweeAddress>\n" +
                "                     <!--Optional:-->\n" +
                "                     <draweeName>?</draweeName>\n" +
                "                     <!--Optional:-->\n" +
                "                     <draweeNo>?</draweeNo>\n" +
                "                     <!--Optional:-->\n" +
                "                     <drawerAccount>?</drawerAccount>\n" +
                "                     <!--Optional:-->\n" +
                "                     <drawerCusId>?</drawerCusId>\n" +
                "                     <!--Optional:-->\n" +
                "                     <drawerIdNo>?</drawerIdNo>\n" +
                "                     <!--Optional:-->\n" +
                "                     <drawerIdType>?</drawerIdType>\n" +
                "                     <!--Optional:-->\n" +
                "                     <drawerName>?</drawerName>\n" +
                "                     <!--Optional:-->\n" +
                "                     <dueDate>?</dueDate>\n" +
                "                     <!--Optional:-->\n" +
                "                     <elecBatchId>?</elecBatchId>\n" +
                "                     <!--Optional:-->\n" +
                "                     <elecId>?</elecId>\n" +
                "                     <!--Optional:-->\n" +
                "                     <issueDate>?</issueDate>\n" +
                "                     <!--Optional:-->\n" +
                "                     <payeeAccount>?</payeeAccount>\n" +
                "                     <!--Optional:-->\n" +
                "                     <payeeAccounts>?</payeeAccounts>\n" +
                "                     <!--Optional:-->\n" +
                "                     <payeeBankAddress>?</payeeBankAddress>\n" +
                "                     <!--Optional:-->\n" +
                "                     <payeeBankName>?</payeeBankName>\n" +
                "                     <!--Optional:-->\n" +
                "                     <payeeBankNo>?</payeeBankNo>\n" +
                "                     <!--Optional:-->\n" +
                "                     <payeeCusId>?</payeeCusId>\n" +
                "                     <!--Optional:-->\n" +
                "                     <payeeIdNo>?</payeeIdNo>\n" +
                "                     <!--Optional:-->\n" +
                "                     <payeeIdType>?</payeeIdType>\n" +
                "                     <!--Optional:-->\n" +
                "                     <payeeName>?</payeeName>\n" +
                "                     <!--Optional:-->\n" +
                "                     <tradeType>?</tradeType>\n" +
                "                  </ROW>\n" +
                "               </DETAIL>\n" +
                "               <!--Optional:-->\n" +
                "               <elecBatchId>?</elecBatchId>\n" +
                "               <!--Optional:-->\n" +
                "               <appDate>?</appDate>\n" +
                "               <elecCount>?</elecCount>\n" +
                "               <elecSum>?</elecSum>\n" +
                "               <discIr>?</discIr>\n" +
                "               <!--Optional:-->\n" +
                "               <dueDate>?</dueDate>\n" +
                "               <inWayDays>?</inWayDays>\n" +
                "            </BODY>\n" +
                "         </XERP>\n" +
                "      </ws:applyElecBillTrade>\n" +
                "   </soapenv:Body>\n" +
                "</soapenv:Envelope>";

        postXml(url, params);
    }

    @Test
    public void wsTest(){
        String url = "https://58.56.82.230:4430/web/1/http/0/10.10.11.7:7001/XERP/service/TxService";
        String params ="<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/ext/envelope/\" xmlns:ser=\"http://server.xfire.xerp.nstc.com\">\n" +
                "   <soapenv:Header/>\n" +
                "   <soapenv:Body>\n" +
                "      <ser:send>\n" +
                "         <ser:in0>\n" +
                "            &lt;XERP>\n" +
                "                &lt;HEAD>\n" +
                "                   &lt;BATCH_NO>123423&lt;/BATCH_NO>&lt;BIZCODE>5201&lt;/BIZCODE>\n" +
                "                &lt;/HEAD>\n" +
                "              &lt;BODY>\n" +
                "                 &lt;ERPTXID>601222&lt;/ERPTXID>\n" +
                "                 &lt;TXCODE>104&lt;/TXCODE>\n" +
                "                 &lt;Amount>12323&lt;/Amount>\n" +
                "                 &lt;REPURCHASEMARKCODE>RM00&lt;/REPURCHASEMARKCODE>\n" +
                "                 &lt;INTEREST>5.23&lt;/INTEREST>\n" +
                "                 &lt;TXDATE>2018-05-30&lt;/TXDATE>\n" +
                "                 &lt;MEMBERNAME>山东重工集团财务有限公司&lt;/MEMBERNAME>\n" +
                "                 &lt;MEMBERBANKNO>907451000039&lt;/MEMBERBANKNO>\n" +
                "                 &lt;OPNAME>山重测试&lt;/OPNAME>\n" +
                "                 &lt;OPBANKNO>907451000089&lt;/OPBANKNO>\n" +
                "                 &lt;Opaccount>23423>&lt;/Opaccount>\n" +
                "                 &lt;MEMO>&lt;/MEMO>\n" +
                "                 &lt;TRANSFERMARKCODE>1&lt;/TRANSFERMARKCODE>\n" +
                "                 &lt;DETAIL>\n" +
                "                     &lt;ROW>\n" +
                "                       &lt;BILLNO>190745100003920170531087078869&lt;/BILLNO>\n" +
                "                     &lt;/ROW>\n" +
                "                     &lt;ROW>\n" +
                "                       &lt;BILLNO>190745100003920170531087078844&lt;/BILLNO>\n" +
                "                     &lt;/ROW>\n" +
                "                     &lt;ROW>\n" +
                "                       &lt;BILLNO>190745100003920170531087078801&lt;/BILLNO>\n" +
                "                     &lt;/ROW>\n" +
                "                 &lt;/DETAIL>\n" +
                "               &lt;/BODY>\n" +
                "            &lt;/XERP>\n" +
                "         </ser:in0>\n" +
                "      </ser:send>\n" +
                "   </soapenv:Body>\n" +
                "</soapenv:Envelope>";
        postXml(url, params);
    }

    @Test
    public void xfireTest(){
        xfire("http://11.6.8.13:8812/ws/webservices/txService","");
    }

    private void xfire(String strURL, String params){
//        Service srModel = new ObjectServiceFactory().create(TxServicePortType.class);
//        XFireProxyFactory factory = new XFireProxyFactory(XFireFactory
//                .newInstance().getXFire());// 创建工厂实例
//        String helloURL = strURL;
//        try {

//            ApplyElecBillTradeRequest ret = new ApplyElecBillTradeRequest();
//            ret.getHead().setBizCode("ABC");
//            ret.getHead().setBatchNo("DEF");
//            ElecBillTrade info = new ElecBillTrade();
//            info.setAppDate(String.format("%tD", new Date()));
//            info.setIssueDate(String.format("%tF", new Date()));
//            info.setAccepAmount(1.1);
//            ret.addBodyData(info);
//            ret.getBody().setElecBatchId("333");
//
//            JAXBContext context = JAXBContext.newInstance(ret.getClass());
//            Marshaller marshaller = context.createMarshaller();
//            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
//
//            StringWriter writer = new StringWriter();
//            marshaller.marshal(ret, writer);

//            TxServicePortType service = (TxServicePortType) factory.create(srModel,
//                    helloURL);
//            String req = writer.toString();
//            System.out.println("req:" + req);
//            System.out.println("service:" + service.send("123456"));
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
    }

    private void postXml(String strURL, String params) {
            try {
                //采用绕过验证的方式处理https请求
                SSLContext sslcontext = createIgnoreVerifySSL();



                // 设置协议http和https对应的处理socket链接工厂的对象
                Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
                        .register("http", PlainConnectionSocketFactory.INSTANCE)
                        .register("https", new SSLConnectionSocketFactory(sslcontext))
                        .build();
                PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);



                HttpClients.custom().setConnectionManager(connManager);



                CloseableHttpClient httpclient = HttpClients.custom().setConnectionManager(connManager).build();
                HttpPost httpPost = new HttpPost(strURL);
                httpPost.addHeader("Content-Type","text/xml;charset=UTF-8");
                httpPost.addHeader("Cookie","language=zh_CN; VisitTimes=0; ENABLE_RANDCODE=0; LoginMode=2; AppCount=1; remoteAppCount=0; websvr_cookie=%zd; collection=%7B%7D; g_LoginPage=login_psw; UsingDkey=0; VpnLine=https%3A%2F%2F58.56.82.230%3A4430%2Fpor%2Flogin_psw.csp; TWFID=720007acaa20ca9b; haveLogin=1; scacheUseable=0");
                httpPost.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.87 Safari/537.36");
                //解决中文乱码问题
                StringEntity stringEntity = new StringEntity(params,"UTF-8");
                stringEntity.setContentEncoding("UTF-8");

                httpPost.setEntity(stringEntity);

                log.debug("Executing request " + httpPost.getRequestLine());

//                SSLSocketFactory.getSocketFactory().setHostnameVerifier(new AllowAllHostnameVerifier());

                //   Create a custom response handler
                ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
                    @Override
                    public String handleResponse(final HttpResponse response)
                            throws ClientProtocolException, IOException {//
                        int status = response.getStatusLine().getStatusCode();
                        if (status >= 200 && status < 300) {

                            HttpEntity entity = response.getEntity();


                            return entity != null ? EntityUtils.toString(entity) : null;
                        } else {
                            throw new ClientProtocolException(
                                    "Unexpected response status: " + status);
                        }
                    }
                };
                String responseBody = httpclient.execute(httpPost, responseHandler);
                log.debug("----------------------------------------");
                log.debug(responseBody);

            } catch (Exception e) {
                System.out.println(e);
            }
        }
    /**
     * 绕过验证
     *
     * @return
     * @throws NoSuchAlgorithmException
     * @throws KeyManagementException
     */
    public static SSLContext createIgnoreVerifySSL() throws NoSuchAlgorithmException, KeyManagementException {
        SSLContext sc = SSLContext.getInstance("SSLv3");

        // 实现一个X509TrustManager接口，用于绕过验证，不用修改里面的方法
        X509TrustManager trustManager = new X509TrustManager() {
            @Override
            public void checkClientTrusted(
                    java.security.cert.X509Certificate[] paramArrayOfX509Certificate,
                    String paramString) throws CertificateException {
            }

            @Override
            public void checkServerTrusted(
                    java.security.cert.X509Certificate[] paramArrayOfX509Certificate,
                    String paramString) throws CertificateException {
            }

            @Override
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return null;
            }
        };

        sc.init(null, new TrustManager[] { trustManager }, null);
        return sc;
    }

    @Test
    public void testPost(){
        String data = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ws=\"ws.lms.transino.net\">\n" +
                "   <soapenv:Header/>\n" +
                "   <soapenv:Body>\n" +
                "      <ws:applyElecBillTrade>\n" +
                "<XERP>\n" +
                "<HEAD>\n" +
                "<BATCH_NO>\n" +
                "</BATCH_NO>\n" +
                "<BIZCODE>5205</BIZCODE>\n" +
                "</HEAD>\n" +
                "<BODY>\n" +
                "<elecBatchId>54</elecBatchId>\n" +
                "<appDate>2018-05-28</appDate>\n" +
                "<elecCount>1</elecCount>\n" +
                "<elecSum>500000.00</elecSum>\n" +
                "<DETAIL>\n" +
                "<ROW>\n" +
                "<elecBatchId>54</elecBatchId>\n" +
                "<elecId>17182</elecId>\n" +
                "<accepNo>190745100003920171018100024499</accepNo>\n" +
                "<accepDielType>2</accepDielType>\n" +
                "<bown>2</bown>\n" +
                "<accepCurrType>RMB</accepCurrType>\n" +
                "<accepAmount>500000</accepAmount>\n" +
                "<issueDate>2017-10-18</issueDate>\n" +
                "<dueDate>2017-11-30</dueDate>\n" +
                "<draweeNo>102110000130</draweeNo>\n" +
                "<draweeName>中国工商银行天津市成都道支行</draweeName>\n" +
                "<draweeAddress>\n" +
                "</draweeAddress>\n" +
                "<drawerIdType>\n" +
                "</drawerIdType>\n" +
                "<drawerIdNo>\n" +
                "</drawerIdNo>\n" +
                "<drawerCusId>\n" +
                "</drawerCusId>\n" +
                "<drawerName>潍柴动力股份有限公司</drawerName>\n" +
                "<drawerAccount>201101104008013</drawerAccount>\n" +
                "<payeeBankNo>907451000039</payeeBankNo>\n" +
                "<payeeBankName>山东重工集团财务有限公司</payeeBankName>\n" +
                "<payeeBankAddress>\n" +
                "</payeeBankAddress>\n" +
                "<payeeIdType>\n" +
                "</payeeIdType>\n" +
                "<payeeIdNo>\n" +
                "</payeeIdNo>\n" +
                "<payeeCusId>\n" +
                "</payeeCusId>\n" +
                "<payeeName>潍坊宝润机械有限公司</payeeName>\n" +
                "<payeeAccount>201103104926016</payeeAccount>\n" +
                "<tradeType>2</tradeType>\n" +
                "</ROW>\n" +
                "</DETAIL>\n" +
                "</BODY>\n" +
                "</XERP>\n" +
                "      </ws:applyElecBillTrade>\n" +
                "   </soapenv:Body>\n" +
                "</soapenv:Envelope>";
        soapPost("http://localhost:8090/webservices/applyElecBillTradeWs", data);
    }

    /**
     * 发送HttpPost请求
     *
     * @param strURL
     *            服务地址
     * @param params
     *
     * @return 成功:返回json字符串<br/>
     */
    public String soapPost(String strURL, String params) {
        try {
            URL url = new URL(strURL);// 创建连接
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setUseCaches(false);
            connection.setInstanceFollowRedirects(true);
            connection.setRequestMethod("POST"); // 设置请求方式
//            connection.setRequestProperty("Accept", "text/xml;charset=utf-8"); // 设置接收数据的格式
            connection.setRequestProperty("Content-Type", "text/xml;charset=utf-8"); // 设置发送数据的格式
            connection.connect();
            OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(), "UTF-8"); // utf-8编码
            out.append(params);
            out.flush();
            out.close();

            int code = connection.getResponseCode();
            InputStream is = null;
            if (code == 200) {
                is = connection.getInputStream();
            } else {
                is = connection.getErrorStream();
            }

            // 读取响应
            int length = 1024;//(int) connection.getContentLength();// 获取长度
            if (length != -1) {
                byte[] data = new byte[length];
                byte[] temp = new byte[512];
                int readLen = 0;
                int destPos = 0;
                while ((readLen = is.read(temp)) > 0) {
                    System.arraycopy(temp, 0, data, destPos, readLen);
                    destPos += readLen;
                }
                String result = new String(data, "UTF-8"); // 文字编码
                log.debug(result);
                return result;
            }

        } catch (IOException e) {
            log.error("Exception occur when send http post request!", e);
        }
        return "error"; // 自定义错误信息
    }
}