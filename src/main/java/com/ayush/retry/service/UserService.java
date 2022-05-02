package com.ayush.retry.service;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;

public interface UserService {

    /*@Retryable(value = RuntimeException.class,maxAttempts = 2,backoff = @Backoff(delay = 10000))*/
    @Retryable(value = RuntimeException.class,maxAttemptsExpression ="${retry.maxAttempt}" ,backoff = @Backoff(delayExpression = "${retry.maxDelay}"))
    void getAllStudent() throws RuntimeException;

    @Recover
    void recover();

    void callRetryMethod();
}
