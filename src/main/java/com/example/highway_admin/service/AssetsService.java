package com.example.highway_admin.service;

import com.example.highway_admin.base.count;
import com.example.highway_admin.domain.Assets;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface AssetsService {
    int deleteByPrimaryKey(Integer id);

    int insert(Assets record);

    int insertSelective(Assets record);

    Assets selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Assets record);

    int updateByPrimaryKeyWithBLOBs(Assets record);

    int updateByPrimaryKey(Assets record);

    List<Assets> selectByPrimaryKey();

    PageInfo<Assets> selectByPrimaryKey(Assets record);

    List<count> selectCount(String assetsType);

    int selectMaxID();
}
