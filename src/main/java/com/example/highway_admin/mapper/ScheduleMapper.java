package com.example.highway_admin.mapper;


import com.example.highway_admin.domain.Schedule;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ScheduleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Schedule record);

    int insertSelective(Schedule record);

    Schedule selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Schedule record);

    int updateByPrimaryKeyWithBLOBs(Schedule record);

    int updateByPrimaryKey(Schedule record);

    List<Schedule> selectByPrimaryKey();

    List<Schedule> selectByPrimaryKey(Schedule record);
}