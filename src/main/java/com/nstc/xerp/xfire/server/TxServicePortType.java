package com.nstc.xerp.xfire.server;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * @author lee
 * @since 5.0
 */
@WebService(name = "TxService", targetNamespace = "http://server.xfire.xerp.nstc.com")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface TxServicePortType {

    @WebMethod
    @WebResult(name = "out", targetNamespace = "http://server.xfire.xerp.nstc.com")
    @RequestWrapper(localName = "send", targetNamespace = "http://server.xfire.xerp.nstc.com", className = "com.nstc.xerp.xfire.server.Send")
    @ResponseWrapper(localName = "sendResponse", targetNamespace = "http://server.xfire.xerp.nstc.com", className = "com.nstc.xerp.xfire.server.SendResponse")
    public String send(
            @WebParam(name = "in0", targetNamespace = "http://server.xfire.xerp.nstc.com")
                    String in0);

}