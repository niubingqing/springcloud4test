package com.bqniu.jpademo.dao;

import com.bqniu.jpademo.dataobject.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDAO extends JpaRepository<User,Integer> {
    List<User> findByName(String name);

    @Override
    void delete(User user);

    @Override
    void deleteById(Integer integer);

    @Override
    void deleteAll();

    @Override
    void deleteInBatch(Iterable<User> entities);

}
