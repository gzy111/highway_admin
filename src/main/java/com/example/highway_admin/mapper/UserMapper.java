package com.example.highway_admin.mapper;

import com.example.highway_admin.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKeyWithBLOBs(User record);

    int updateByPrimaryKey(User record);

    List<User> selectByPrimaryKey();

    List<User> selectByPrimaryKey(User record);

    int selectMaxID();

    User login(int id,String password);

    User selectUser(int id);
}