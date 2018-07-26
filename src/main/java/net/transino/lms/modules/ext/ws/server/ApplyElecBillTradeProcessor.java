package net.transino.lms.modules.ext.ws.server;

import net.transino.lms.modules.ext.ws.server.apply.ApplyElecBillTradeRequest;
import net.transino.lms.modules.ext.ws.server.apply.ApplyElecBillTradeResponse;

/**
 * @author lee
 * @since 5.0
 */
public class ApplyElecBillTradeProcessor extends AbstractProcessor<ApplyElecBillTradeRequest, ApplyElecBillTradeResponse> {

    ApplyElecBillTradeProcessor(String bizCode) {
        this.bizCode = bizCode;
    }

    @Override
    protected void doProcessor(ApplyElecBillTradeRequest request, ApplyElecBillTradeResponse response) {

    }
}