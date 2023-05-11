package com.example.highway_admin.mapper;


import com.example.highway_admin.base.count;
import com.example.highway_admin.base.countTable;
import com.example.highway_admin.domain.Case;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CaseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Case record);

    int insertSelective(Case record);



    int updateByPrimaryKeySelective(Case record);

    int updateByPrimaryKeyWithBLOBs(Case record);

    int updateByPrimaryKey(Case record);

    List<Case> selectByPrimaryKey();

    List<Case> selectByPrimaryKey(Case record);

    List<Case> selectCountType(Case record);

    List<count>  selectCount(String caseType);

    int selectMaxID();
}