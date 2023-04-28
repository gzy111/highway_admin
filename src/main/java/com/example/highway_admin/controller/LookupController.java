package com.example.highway_admin.controller;

import com.example.highway_admin.Utils.JsonModel;
import com.example.highway_admin.domain.Lookup;
import com.example.highway_admin.service.LookupService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/LookUp")
@Api(tags = "LookUp", value = "中间表接口")
public class LookupController {

    @Autowired
    LookupService lookupService;

    @GetMapping("/deleteById")
    @ApiOperation(value = "删除中间值", notes = "成功返回1")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id",required = true,dataType = "integer", paramType = "query"),
    })
    public JsonModel<Integer> deleteByPrimaryKey(Integer id) {
        JsonModel<Integer> jsonModel = new JsonModel<>();
        try {
            jsonModel.setData(lookupService.deleteByPrimaryKey(id));
            jsonModel.setCode("0000");
            jsonModel.setMsg("删除成功");
        }catch (Exception e){
            jsonModel.setCode("404");
            jsonModel.setMsg("删除失败");
        }
        return jsonModel;
    }


    @ApiOperation(value = "添加中间值", notes = "成功返回1")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "code", value = "编号",dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "typeName", value = "类型名称",dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "codeName", value = "编号名称",dataType = "Date",paramType = "query"),
    })
    @PostMapping("/insert")
    public JsonModel<Integer> insertSelective(@RequestBody Lookup record) {
        JsonModel<Integer> jsonModel = new JsonModel<>();
        try {
            jsonModel.setData(lookupService.insertSelective(record));
            jsonModel.setCode("0000");
            jsonModel.setMsg("添加成功");
        }catch (Exception e){
            jsonModel.setCode("404");
            jsonModel.setMsg("添加失败");
        }
        return jsonModel;
    }

    @ApiOperation(value = "更新中间值", notes = "成功返回1")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "code", value = "编号",dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "typeName", value = "类型名称",dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "codeName", value = "编号名称",dataType = "Date",paramType = "query"),
    })
    @PutMapping("/update")
    public JsonModel<Integer>  updateByPrimaryKeySelective(Lookup record) {
        JsonModel<Integer> jsonModel = new JsonModel<>();
        try {
            jsonModel.setData(lookupService.updateByPrimaryKeySelective(record));
            jsonModel.setCode("0000");
            jsonModel.setMsg("更新成功");
        }catch (Exception e){
            jsonModel.setCode("404");
            jsonModel.setMsg("更新失败");
        }
        return jsonModel;
    }


    @GetMapping("selectAll")@ApiOperation(value = "查询所有信息不分页", notes = "查询所有信息不分页")
    public JsonModel<List<Lookup>> selectByPrimaryKey() {
        JsonModel<List<Lookup>> jsonModel = new JsonModel<>();
        try {
            jsonModel.setData(lookupService.selectByPrimaryKey());
            jsonModel.setCode("0000");
            jsonModel.setMsg("查询成功");
        }catch (Exception e){
            jsonModel.setCode("404");
            jsonModel.setMsg("查询失败");
        }
        return jsonModel;
    }

    @ApiOperation(value = "获取中间值分页列表", notes = "返回list，")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "typeName", value = "类型名称",dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "pageNum", value = "页数", defaultValue = "1",dataType = "integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "一页多少条", defaultValue = "10",dataType ="integer", paramType = "query"),
    })
    @GetMapping("/selectPageInfo")
    public JsonModel<PageInfo<Lookup>> selectByPrimaryKey(Lookup record) {
        JsonModel<PageInfo<Lookup>> jsonModel = new JsonModel<>();
        System.out.println(record);
        try {
            PageInfo<Lookup> pageInfo = lookupService.selectByPrimaryKey(record);
            jsonModel.setData(pageInfo);
            jsonModel.setCode("0000");
            jsonModel.setMsg("查询成功");
        }catch (Exception e){
            jsonModel.setCode("404");
            jsonModel.setMsg("查询失败");
        }
        return jsonModel;
    }

}
