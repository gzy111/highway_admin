package com.example.highway_admin.service.Impl;

import com.example.highway_admin.base.count;
import com.example.highway_admin.domain.Case;
import com.example.highway_admin.mapper.CaseMapper;
import com.example.highway_admin.service.CaseService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CaseImpl implements CaseService {

    @Autowired
    CaseMapper caseMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return caseMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Case record) {
        return caseMapper.insert(record);
    }

    @Override
    public int insertSelective(Case record) {
        return caseMapper.insertSelective(record);
    }


    @Override
    public int updateByPrimaryKeySelective(Case record) {
        return caseMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKeyWithBLOBs(Case record) {
        return caseMapper.updateByPrimaryKeyWithBLOBs(record);
    }

    @Override
    public int updateByPrimaryKey(Case record) {
        return caseMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Case> selectByPrimaryKey() {
        return caseMapper.selectByPrimaryKey();
    }

    @Override
    public PageInfo<Case> selectByPrimaryKey(Case record) {
        System.out.println(record.toString());
        PageHelper.startPage(record.getPageNum(), record.getPageSize());
        Page<Case> list = (Page<Case>) caseMapper.selectByPrimaryKey(record);
        PageInfo<Case> pageInfo = list.toPageInfo();
        return pageInfo;
    }

    @Override
    public List<Case> selectCountType(Case record) {
        return caseMapper.selectCountType(record);
    }

    @Override
    public List<count> selectCount(String caseType) {
        return caseMapper.selectCount(caseType);
    }

    @Override
    public int selectMaxID() {
        return caseMapper.selectMaxID();
    }
}
