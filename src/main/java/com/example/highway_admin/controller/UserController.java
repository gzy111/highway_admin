package com.example.highway_admin.controller;


import com.example.highway_admin.Utils.JsonModel;
import com.example.highway_admin.domain.User;
import com.example.highway_admin.service.UserService;
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
@RequestMapping("/User")
@Api(tags = "User", value = "员工接口")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/deleteById")
    @ApiOperation(value = "删除用户", notes = "成功返回1")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id",required = true,dataType = "integer", paramType = "query"),
    })
    public JsonModel<Integer> deleteByPrimaryKey(Integer id) {
        JsonModel<Integer> jsonModel = new JsonModel<>();
        try {
            jsonModel.setData(userService.deleteByPrimaryKey(id));
            jsonModel.setCode("0000");
            jsonModel.setMsg("删除成功");
        }catch (Exception e){
            jsonModel.setCode("404");
            jsonModel.setMsg("删除失败");
        }
        return jsonModel;
    }


    @ApiOperation(value = "添加用户", notes = "成功返回1")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "员工名称",dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "password", value = "密码",dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "phone", value = "手机",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "state", value = "状态",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "addres", value = "地址", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "role", value = "角色", dataType = "String", paramType = "query"),
    })
    @PostMapping("/insert")
    public JsonModel<Integer> insertSelective( User record) {
        JsonModel<Integer> jsonModel = new JsonModel<>();
        try {
            record.setState("1");
            record.setCreateTime(new Date());
            record.setId(userService.selectMaxID()+1);
            jsonModel.setData(userService.insertSelective(record));
            jsonModel.setCode("0000");
            jsonModel.setMsg("添加成功");
        }catch (Exception e){
            jsonModel.setCode("404");
            jsonModel.setMsg("添加失败");
        }
        return jsonModel;
    }

//    @GetMapping("/selectByID")
//    public JsonModel<User> selectByPrimaryKey(Integer id) {
//        JsonModel<User> jsonModel = new JsonModel<>();
//        try {
//         User user=userService.selectByPrimaryKey(id);
//            jsonModel.setData(user);
//            jsonModel.setCode("0000");
//            jsonModel.setMsg("查询成功");
//        }catch (Exception e){
//            jsonModel.setCode("404");
//            jsonModel.setMsg("查询失败");
//        }
//        return jsonModel;
//    }


    @ApiOperation(value = "更新用户", notes = "成功返回1")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id",required = true,dataType = "integer", paramType = "query"),
            @ApiImplicitParam(name = "userName", value = "员工名称",dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "password", value = "密码",dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "phone", value = "手机",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "state", value = "状态",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "addres", value = "地址", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "role", value = "角色", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "checkFlg", value = "打卡情况", dataType = "String", paramType = "query"),
    })
    @PutMapping("/update")
    public JsonModel<Integer>  updateByPrimaryKeySelective(User record) {
        JsonModel<Integer> jsonModel = new JsonModel<>();
        try {
            jsonModel.setData(userService.updateByPrimaryKeySelective(record));
            jsonModel.setCode("0000");
            jsonModel.setMsg("更新成功");
        }catch (Exception e){
            jsonModel.setCode("404");
            jsonModel.setMsg("更新失败");
        }
        return jsonModel;
    }


    @GetMapping("selectAll")@ApiOperation(value = "查询所有信息不分页", notes = "查询所有信息不分页")
    public JsonModel<List<User>> selectByPrimaryKey() {
        JsonModel<List<User>> jsonModel = new JsonModel<>();
        try {
            jsonModel.setData(userService.selectByPrimaryKey());
            jsonModel.setCode("0000");
            jsonModel.setMsg("查询成功");
        }catch (Exception e){
            jsonModel.setCode("404");
            jsonModel.setMsg("查询失败");
        }
        return jsonModel;
    }

    @ApiOperation(value = "获取用户分页列表", notes = "返回list，")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "state", value = "状态",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "id", value = "id",dataType = "integer", paramType = "query"),
            @ApiImplicitParam(name = "pageNum", value = "页数", defaultValue = "1",dataType = "integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "一页多少条", defaultValue = "10",dataType ="integer", paramType = "query"),
    })
    @GetMapping("/selectPageInfo")
    public JsonModel<PageInfo<User>> selectByPrimaryKey(User record) {
        JsonModel<PageInfo<User>> jsonModel = new JsonModel<>();
        try {
            PageInfo<User> pageInfo = userService.selectByPrimaryKey(record);
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
