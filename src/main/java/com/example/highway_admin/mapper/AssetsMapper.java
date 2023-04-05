package com.example.highway_admin.mapper;

import com.example.highway_admin.base.count;
import com.example.highway_admin.domain.Assets;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AssetsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Assets record);

    int insertSelective(Assets record);

    Assets selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Assets record);

    int updateByPrimaryKeyWithBLOBs(Assets record);

    int updateByPrimaryKey(Assets record);

    List<Assets> selectByPrimaryKey();

    List<Assets> selectByPrimaryKey(Assets record);

    List<count>  selectCount(String assetsType);

    int selectMaxID();
}