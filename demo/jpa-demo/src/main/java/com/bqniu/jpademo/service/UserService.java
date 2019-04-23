package com.bqniu.jpademo.service;

import com.bqniu.jpademo.dataobject.User;

import javax.jws.soap.SOAPBinding;
import java.util.List;

public interface UserService {
    List<User> findByName(String name) throws InterruptedException;
    void insertUser(User user);
}
