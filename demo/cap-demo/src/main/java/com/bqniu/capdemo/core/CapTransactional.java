package com.bqniu.capdemo.core;

import com.bqniu.capdemo.core.agent.TransactionalAgent;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.UUID;

public class CapTransactional implements ICapTransactional {
    private final String EXCHANGE_NAME = "trans";

    @Override
    public CapTransactionContext beginCapTranscation() {
        CapTransactionContext context = new CapTransactionContext();
        context.setTranscationId(UUID.randomUUID().toString());

        return context;
    }

    @Override
    public void abortCapTranscation() {

    }

    @Override
    public void rollBackCapTranscation(String serviceId) {
        //撤销本地操作
        //作废所有消息
        //发送rollback全局消息
    }

    @Override
    public void commitCapTranscation() {

    }

    @Override
    public void preCommitCapTranscation() {

    }

    @Override
    public void excute() {

    }
}
