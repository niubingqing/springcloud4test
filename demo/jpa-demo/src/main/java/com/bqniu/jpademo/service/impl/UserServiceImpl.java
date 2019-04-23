package com.bqniu.jpademo.service.impl;

import com.bqniu.capdemo.core.annotation.TCCAdd;
import com.bqniu.jpademo.dao.UserDAO;
import com.bqniu.jpademo.dataobject.User;
import com.bqniu.jpademo.service.UserService;
import org.hibernate.cfg.annotations.reflection.JPAMetadataProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.query.JpaEntityMetadata;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    @Cacheable(value = "test",key ="'test:user:name:'.concat(#root.args[0])")
    public List<User> findByName(String name) throws InterruptedException {
        Thread.sleep(3000);

        return userDAO.findByName(name);
    }

    @TCCAdd
    @Override
    public void insertUser(User user) {
        userDAO.save(user);
    }
}
