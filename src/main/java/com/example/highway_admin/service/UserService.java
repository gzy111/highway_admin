package com.example.highway_admin.service;

import com.example.highway_admin.domain.User;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface UserService {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKeyWithBLOBs(User record);

    int updateByPrimaryKey(User record);

    List<User> selectByPrimaryKey();

    PageInfo<User> selectByPrimaryKey(User record);

    int selectMaxID();
}
