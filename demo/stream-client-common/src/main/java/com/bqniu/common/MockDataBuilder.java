package com.bqniu.common;

import com.bqniu.common.dataobject.MessageInfo;

public class MockDataBuilder {
    public static MessageInfo getMessageInfoByWFid(){
        MessageInfo messageInfo=new MessageInfo();
        messageInfo.setServiceId("sample1");
        messageInfo.setNextStepExchange("sample2-in");
        messageInfo.setNextStepRoutingkey("");
        messageInfo.setWfId("1");
        messageInfo.setWfInstanceId("1");

        return messageInfo;
    }
}
