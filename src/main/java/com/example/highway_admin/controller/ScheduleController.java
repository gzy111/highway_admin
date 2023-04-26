package com.example.highway_admin.controller;

import com.example.highway_admin.Utils.JsonModel;
import com.example.highway_admin.base.count;
import com.example.highway_admin.domain.Assets;
import com.example.highway_admin.domain.Schedule;
import com.example.highway_admin.service.ScheduleService;
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
@RequestMapping("/Schedule")
@Api(tags = "Schedule", value = "排班接口")
public class ScheduleController {

    @Autowired
    ScheduleService scheduleService;

    @GetMapping("/deleteById")
    @ApiOperation(value = "删除排班", notes = "成功返回1")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "排班id",required = true,dataType = "integer", paramType = "query"),
    })
    public JsonModel<Integer> deleteByPrimaryKey(Integer id) {
        JsonModel<Integer> jsonModel = new JsonModel<>();
        try {
            jsonModel.setData(scheduleService.deleteByPrimaryKey(id));
            jsonModel.setCode("0000");
            jsonModel.setMsg("删除成功");
        }catch (Exception e){
            jsonModel.setCode("404");
            jsonModel.setMsg("删除失败");
        }
        return jsonModel;
    }


    @ApiOperation(value = "添加排班", notes = "成功返回1")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "员工",dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "startTime", value = "开始时间",dataType = "Date", paramType = "query"),
            @ApiImplicitParam(name = "endTime", value = "结束时间",dataType = "Date",paramType = "query"),
            @ApiImplicitParam(name = "type", value = "排班类型", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "data", value = "排班信息", dataType = "String", paramType = "query"),
    })
    @PostMapping("/insert")
    public JsonModel<Integer> insertSelective(Schedule record) {
        JsonModel<Integer> jsonModel = new JsonModel<>();
        try {
            record.setState("0");
            record.setId(scheduleService.selectMaxID()+1);
            jsonModel.setData(scheduleService.insertSelective(record));
            jsonModel.setCode("0000");
            jsonModel.setMsg("添加成功");
        }catch (Exception e){
            jsonModel.setCode("404");
            jsonModel.setMsg("添加失败");
        }
        return jsonModel;
    }


    public Schedule selectByPrimaryKey(Integer id) {
        return scheduleService.selectByPrimaryKey(id);
    }


    @ApiOperation(value = "更新排班", notes = "成功返回1")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "排班id",required = true,dataType = "integer", paramType = "query"),
            @ApiImplicitParam(name = "userId", value = "员工",dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "startTime", value = "开始时间",dataType = "Date", paramType = "query"),
            @ApiImplicitParam(name = "endTime", value = "结束时间",dataType = "Date",paramType = "query"),
            @ApiImplicitParam(name = "state", value = "状态",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "type", value = "排班类型", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "data", value = "排班信息", dataType = "String", paramType = "query"),
    })
    @PutMapping("/update")
    public JsonModel<Integer>  updateByPrimaryKeySelective(Schedule record) {
        JsonModel<Integer> jsonModel = new JsonModel<>();
        try {
            jsonModel.setData(scheduleService.updateByPrimaryKeySelective(record));
            jsonModel.setCode("0000");
            jsonModel.setMsg("更新成功");
        }catch (Exception e){
            jsonModel.setCode("404");
            jsonModel.setMsg("更新失败");
        }
        return jsonModel;
    }


    @GetMapping("selectAll")@ApiOperation(value = "查询所有信息不分页", notes = "查询所有信息不分页")
    public JsonModel<List<Schedule>> selectByPrimaryKey() {
        JsonModel<List<Schedule>> jsonModel = new JsonModel<>();
        try {
            jsonModel.setData(scheduleService.selectByPrimaryKey());
            jsonModel.setCode("0000");
            jsonModel.setMsg("查询成功");
        }catch (Exception e){
            jsonModel.setCode("404");
            jsonModel.setMsg("查询失败");
        }
        return jsonModel;
    }

    @ApiOperation(value = "获取排班分页列表", notes = "返回list，")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "资产id",defaultValue = "",dataType = "integer", paramType = "query"),
            @ApiImplicitParam(name = "userId", value = "员工(可以模糊查询)",dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "data", value = "排班信息(可以模糊查询)",dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "state", value = "状态",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "pageNum", value = "页数", defaultValue = "1",dataType = "integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "一页多少条", defaultValue = "10",dataType ="integer", paramType = "query"),
    })
    @GetMapping("/selectPageInfo")
    public JsonModel<PageInfo<Schedule>> selectByPrimaryKey(Schedule record) {
        JsonModel<PageInfo<Schedule>> jsonModel = new JsonModel<>();
        try {
            PageInfo<Schedule> equipments = scheduleService.selectByPrimaryKey(record);
            jsonModel.setData(equipments);
            jsonModel.setCode("0000");
            jsonModel.setMsg("查询成功");
        }catch (Exception e){
            jsonModel.setCode("404");
            jsonModel.setMsg("查询失败");
        }
        return jsonModel;
    }

    @GetMapping("/selcetCount")
    @ApiOperation(value = "获取排班数量", notes = "返回list，type state 只能任选一个有值")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "type", value = "类型", defaultValue = "0",dataType = "String",
                    paramType = "query"),
            @ApiImplicitParam(name = "state", value = "状态",dataType = "String",
                    paramType = "query"),
    })
    public JsonModel<List<count>> selectCount(String type,String state) {
        JsonModel<List<count>> jsonModel = new JsonModel<>();
        try {
            jsonModel.setData(scheduleService.selectCount(type,state));
            jsonModel.setCode("0000");
            jsonModel.setMsg("查询成功");
        }catch (Exception e){
            jsonModel.setCode("404");
            jsonModel.setMsg("查询失败");
        }

        return jsonModel;
    }



}
