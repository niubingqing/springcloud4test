package com.bqniu.capdemo.core.exception;

import javax.transaction.TransactionalException;

public class CapTranscationalException extends TransactionalException {
    public CapTranscationalException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
