package com.example.highway_admin.service.Impl;

import com.example.highway_admin.base.count;
import com.example.highway_admin.domain.Assets;
import com.example.highway_admin.domain.Schedule;
import com.example.highway_admin.mapper.ScheduleMapper;
import com.example.highway_admin.service.ScheduleService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ScheduleImpl implements ScheduleService {

    @Autowired
    ScheduleMapper scheduleMapper;


    @Override
    public int deleteByPrimaryKey(Integer id) {
        return scheduleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Schedule record) {
        return scheduleMapper.insert(record);
    }

    @Override
    public int insertSelective(Schedule record) {
        return scheduleMapper.insertSelective(record);
    }

    @Override
    public Schedule selectByPrimaryKey(Integer id) {
        return scheduleMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Schedule record) {
        return scheduleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKeyWithBLOBs(Schedule record) {
        return scheduleMapper.updateByPrimaryKeyWithBLOBs(record);
    }

    @Override
    public int updateByPrimaryKey(Schedule record) {
        return scheduleMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Schedule> selectByPrimaryKey() {
        return scheduleMapper.selectByPrimaryKey();
    }

    @Override
    public PageInfo<Schedule> selectByPrimaryKey(Schedule record) {
        PageHelper.startPage(record.getPageNum(), record.getPageSize());
        Page<Schedule> list = (Page<Schedule>) scheduleMapper.selectByPrimaryKey(record);
        PageInfo<Schedule> pageInfo = list.toPageInfo();
        return pageInfo;
    }

    @Override
    public List<count> selectCount(String type, String state) {
        return scheduleMapper.selectCount(type,state);
    }


    @Override
    public int selectMaxID() {
        return scheduleMapper.selectMaxID();
    }
}
