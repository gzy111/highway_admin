package com.example.highway_admin.service;

import com.example.highway_admin.domain.Lookup;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface LookupService {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(Lookup record);

    int updateByPrimaryKeySelective(Lookup record);

    List<Lookup> selectByPrimaryKey();

    PageInfo<Lookup> selectByPrimaryKey(Lookup record);
}
