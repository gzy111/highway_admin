package com.example.highway_admin.mapper;


import com.example.highway_admin.domain.Lookup;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LookupMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Lookup record);

    int insertSelective(Lookup record);

    Lookup selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Lookup record);

    int updateByPrimaryKey(Lookup record);

    List<Lookup> selectByPrimaryKey();

    List<Lookup> selectByPrimaryKey(Lookup record);
}