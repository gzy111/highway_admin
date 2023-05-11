package com.example.highway_admin.service;

import com.example.highway_admin.base.count;
import com.example.highway_admin.domain.Case;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface CaseService {

    int deleteByPrimaryKey(Integer id);

    int insert(Case record);

    int insertSelective(Case record);



    int updateByPrimaryKeySelective(Case record);

    int updateByPrimaryKeyWithBLOBs(Case record);

    int updateByPrimaryKey(Case record);

    List<Case> selectByPrimaryKey();

    PageInfo<Case> selectByPrimaryKey(Case record);

    List<Case> selectCountType(Case record);

    List<count>  selectCount(String caseType);

    int selectMaxID();
}
