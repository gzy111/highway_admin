package com.example.highway_admin.service.Impl;

import com.example.highway_admin.domain.Lookup;
import com.example.highway_admin.domain.Schedule;
import com.example.highway_admin.mapper.LookupMapper;
import com.example.highway_admin.service.LookupService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LookuoImpl implements LookupService {

    @Autowired
    LookupMapper lookupMapper;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return lookupMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(Lookup record) {
        return lookupMapper.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKeySelective(Lookup record) {
        return lookupMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<Lookup> selectByPrimaryKey() {
        return lookupMapper.selectByPrimaryKey();
    }

    @Override
    public PageInfo<Lookup> selectByPrimaryKey(Lookup record) {
        PageHelper.startPage(record.getPageNum(), record.getPageSize());
        Page<Lookup> list = (Page<Lookup>) lookupMapper.selectByPrimaryKey(record);
        PageInfo<Lookup> pageInfo = list.toPageInfo();
        return pageInfo;
    }
}
