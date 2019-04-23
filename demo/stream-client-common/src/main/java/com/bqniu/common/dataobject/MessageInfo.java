package com.bqniu.common.dataobject;

import lombok.Data;

@Data
public class MessageInfo {
    private String serviceId;
    private String nextStepExchange;
    private String nextStepRoutingkey;
    private Object payload;
    private String wfInstanceId;
    private String wfId;
}
