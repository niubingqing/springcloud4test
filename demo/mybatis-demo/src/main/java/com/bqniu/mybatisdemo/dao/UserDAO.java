package com.bqniu.mybatisdemo.dao;

import com.bqniu.mybatisdemo.entity.User;

public interface UserDAO {
    int deleteByPrimaryKey(Integer id);
    int insert(User record);
    int insertSelective(User record);
    User selectByPrimaryKey(Integer id);
    int updateByPrimaryKeySelective(User record);
    int updateByPrimaryKey(User record);
}
