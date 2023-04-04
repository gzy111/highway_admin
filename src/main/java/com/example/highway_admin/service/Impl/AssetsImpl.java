package com.example.highway_admin.service.Impl;

import com.example.highway_admin.domain.Assets;
import com.example.highway_admin.mapper.AssetsMapper;
import com.example.highway_admin.service.AssetsService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetsImpl implements AssetsService {
    @Autowired
    AssetsMapper assetsMapper;


    @Override
    public int deleteByPrimaryKey(Integer id) {
        return assetsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Assets record) {
        return assetsMapper.insert(record);
    }

    @Override
    public int insertSelective(Assets record) {
        return assetsMapper.insertSelective(record);
    }

    @Override
    public Assets selectByPrimaryKey(Integer id) {
        return assetsMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Assets record) {
        return assetsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKeyWithBLOBs(Assets record) {
        return assetsMapper.updateByPrimaryKeyWithBLOBs(record);
    }

    @Override
    public int updateByPrimaryKey(Assets record) {
        return assetsMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Assets> selectByPrimaryKey() {
        return assetsMapper.selectByPrimaryKey();
    }

    @Override
    public PageInfo<Assets> selectByPrimaryKey(Assets record) {
        PageHelper.startPage(record.getPageNum(), record.getPageSize());
        Page<Assets> list = (Page<Assets>) assetsMapper.selectByPrimaryKey(record);
        PageInfo<Assets> pageInfo = list.toPageInfo();
        return pageInfo;
    }
}
