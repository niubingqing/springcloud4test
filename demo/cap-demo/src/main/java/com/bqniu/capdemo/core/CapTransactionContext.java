package com.bqniu.capdemo.core;

public class CapTransactionContext {
    private String transcationId;
    private String serviceId;
    private String invokeMethod;
    private Object dataContext;
    private Object input;
    private Object output;

    public String getTranscationId() {
        return transcationId;
    }

    public void setTranscationId(String transcationId) {
        this.transcationId = transcationId;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getInvokeMethod() {
        return invokeMethod;
    }

    public void setInvokeMethod(String invokeMethod) {
        this.invokeMethod = invokeMethod;
    }

    public Object getDataContext() {
        return dataContext;
    }

    public void setDataContext(Object dataContext) {
        this.dataContext = dataContext;
    }

    public Object getInput() {
        return input;
    }

    public void setInput(Object input) {
        this.input = input;
    }

    public Object getOutput() {
        return output;
    }

    public void setOutput(Object output) {
        this.output = output;
    }
}
