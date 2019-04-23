package com.bqniu.capdemo.core;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ICapTransactional<T> {
    /*
    *开始分布式事务
    * 发送prepare消息
    * */
    CapTransactionContext beginCapTranscation();

    /*
     *中止分布式事务
     * */
    void abortCapTranscation();

    /*
     *回滚事务
     * */
    void rollBackCapTranscation(String serviceId);

    /*
     *提交分布式事务
     * */
    void commitCapTranscation();

    /*
     *准备提交分布式事务
     * */
    void preCommitCapTranscation();

    /*
     *处理逻辑
     * */
    void excute();
}
