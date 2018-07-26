package com.nstc.xerp.xfire.server.impl;

import com.nstc.xerp.xfire.server.Send;
import com.nstc.xerp.xfire.server.SendResponse;
import com.nstc.xerp.xfire.server.TxServicePortType;

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
@WebService(endpointInterface = "com.nstc.xerp.xfire.server.TxServicePortType",
        name = "TxService", targetNamespace = "http://server.xfire.xerp.nstc.com")
@SOAPBinding(style = SOAPBinding.Style.RPC)

public class TxService implements TxServicePortType {
    @Override
    @WebMethod
    @WebResult(name = "out", targetNamespace = "http://server.xfire.xerp.nstc.com")
    @RequestWrapper(localName = "send", targetNamespace = "http://server.xfire.xerp.nstc.com", className = "com.nstc.xerp.xfire.server.Send")
    @ResponseWrapper(localName = "sendResponse", targetNamespace = "http://server.xfire.xerp.nstc.com", className = "com.nstc.xerp.xfire.server.SendResponse")
    public String send(
            @WebParam(name = "in0", targetNamespace = "http://server.xfire.xerp.nstc.com")
                    String in0){
        return in0;
    }
}