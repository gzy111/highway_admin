package com.example.highway_admin.service.Impl;

import com.example.highway_admin.domain.Schedule;
import com.example.highway_admin.domain.User;
import com.example.highway_admin.mapper.UserMapper;
import com.example.highway_admin.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserImpl implements UserService {

    @Autowired
    UserMapper userMapper;


    @Override
    public int deleteByPrimaryKey(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(User record) {
        return userMapper.insert(record);
    }

    @Override
    public int insertSelective(User record) {
        return userMapper.insertSelective(record);
    }

    @Override
    public User selectByPrimaryKey(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKeyWithBLOBs(User record) {
        return userMapper.updateByPrimaryKeyWithBLOBs(record);
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return userMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<User> selectByPrimaryKey() {
        return userMapper.selectByPrimaryKey();
    }

    @Override
    public PageInfo<User> selectByPrimaryKey(User record) {
        PageHelper.startPage(record.getPageNum(), record.getPageSize());
        Page<User> list = (Page<User>) userMapper.selectByPrimaryKey(record);
        PageInfo<User> pageInfo = list.toPageInfo();
        return pageInfo;
    }

    @Override
    public int selectMaxID() {
        return userMapper.selectMaxID();
    }
}
