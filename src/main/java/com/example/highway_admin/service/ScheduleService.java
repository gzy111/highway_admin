package com.example.highway_admin.service;

import com.example.highway_admin.base.count;
import com.example.highway_admin.domain.Case;
import com.example.highway_admin.domain.Schedule;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ScheduleService {

    int deleteByPrimaryKey(Integer id);

    int insert(Schedule record);

    int insertSelective(Schedule record);

    Schedule selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Schedule record);

    int updateByPrimaryKeyWithBLOBs(Schedule record);

    int updateByPrimaryKey(Schedule record);

    List<Schedule> selectByPrimaryKey();

    PageInfo<Schedule> selectByPrimaryKey(Schedule record);

    List<count> selectCount(String type,String state);

    int selectMaxID();
}
