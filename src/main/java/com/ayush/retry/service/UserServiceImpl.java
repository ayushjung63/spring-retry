package com.ayush.retry.service;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Service;

@Service
@EnableRetry
public class UserServiceImpl implements UserService {

    @Autowired
    private RetryTemplate retryTemplate;

    @Override
    public void getAllStudent() {
        System.out.println("<=============== fetching student list =============>");
        throw new RuntimeException("Student Not Found");
    }

    @Override
    public void recover() {
        System.out.println("<============= unable to connect to student service ============>");
    }

    @Override
    public void callRetryMethod() {
        retryTemplate.execute(x->{
            getAllStudent();
            return true;
        });
    }


}
