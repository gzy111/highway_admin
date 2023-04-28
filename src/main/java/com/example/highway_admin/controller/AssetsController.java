package com.example.highway_admin.controller;

import com.example.highway_admin.Utils.JsonModel;
import com.example.highway_admin.base.count;
import com.example.highway_admin.domain.Assets;
import com.example.highway_admin.service.AssetsService;
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
@RequestMapping("/Assets")
@Api(tags = "Assets", value = "资产接口")
public class AssetsController {

    @Autowired
    AssetsService assetsService;

    @GetMapping("/deleteById")
    @ApiOperation(value = "删除资产", notes = "成功返回1")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "资产id",required = true,dataType = "integer", paramType = "query"),
    })
    public JsonModel<Integer> deleteByPrimaryKey(Integer id) {
        JsonModel<Integer> jsonModel = new JsonModel<>();
        try {
            jsonModel.setData(assetsService.deleteByPrimaryKey(id));
            jsonModel.setCode("0000");
            jsonModel.setMsg("删除成功");
        }catch (Exception e){
            jsonModel.setCode("404");
            jsonModel.setMsg("删除失败");
        }
        return jsonModel;
    }


    @ApiOperation(value = "添加资产", notes = "成功返回1")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "assetsName", value = "资产名称",dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "assetsType", value = "资产类型",dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "state", value = "状态",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "userId", value = "处理员工", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "assetsData", value = "资产信息", dataType = "String", paramType = "query"),
    })
    @PostMapping("/insert")
    public JsonModel<Integer> insertSelective(Assets record) {
        System.out.println(record);
        JsonModel<Integer> jsonModel = new JsonModel<>();
        try {
            record.setCreateTime(new Date());
            record.setId(assetsService.selectMaxID()+1);
            record.setCreateTime(new Date());
            record.setState("false");
            jsonModel.setData(assetsService.insertSelective(record));
            jsonModel.setCode("0000");
            jsonModel.setMsg("添加成功");
        }catch (Exception e){
            jsonModel.setCode("404");
            jsonModel.setMsg("添加失败");
        }
        return jsonModel;
    }



    @ApiOperation(value = "更新资产", notes = "成功返回1")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "资产id",required = true,dataType = "integer", paramType = "query"),
            @ApiImplicitParam(name = "assetsName", value = "资产名称",dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "assetsType", value = "资产类型",dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "state", required = true,value = "状态",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "userId", value = "处理员工", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "assetsData", value = "资产信息", dataType = "String", paramType = "query"),
    })
    @PutMapping("/update")
    public JsonModel<Integer>  updateByPrimaryKeySelective(Assets record) {
        JsonModel<Integer> jsonModel = new JsonModel<>();
        try {
            if (record.getState().equals("1")){
                record.setFinishTime(new Date());
            }
            jsonModel.setData(assetsService.updateByPrimaryKeySelective(record));
            jsonModel.setCode("0000");
            jsonModel.setMsg("更新成功");
        }catch (Exception e){
            jsonModel.setCode("404");
            jsonModel.setMsg("更新失败");
        }
        return jsonModel;

    }


    @GetMapping("selectAll")@ApiOperation(value = "查询所有资产不分页", notes = "查询所有资产不分页")
    public JsonModel<List<Assets>> selectByPrimaryKey() {
        JsonModel<List<Assets>> jsonModel = new JsonModel<>();
        try {
            jsonModel.setData(assetsService.selectByPrimaryKey());
            jsonModel.setCode("0000");
            jsonModel.setMsg("查询成功");
        }catch (Exception e){
            jsonModel.setCode("404");
            jsonModel.setMsg("查询失败");
        }
        return jsonModel;
    }

    @GetMapping("/selectPageInfo")
    @ApiOperation(value = "获取资产列表", notes = "返回list，")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "资产id",defaultValue = "",dataType = "integer", paramType = "query"),
            @ApiImplicitParam(name = "assetsCode", value = "资产code(可以模糊查询)",dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "assetsName", value = "资产名称(可以模糊查询)",dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "assetsType", value = "资产类型",dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "state", value = "状态",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "userId", value = "处理员工", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "assetsData", value = "资产信息", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "pageNum", value = "页数", defaultValue = "1",dataType = "integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "一页多少条", defaultValue = "10",dataType ="integer", paramType = "query"),
    })
    public JsonModel<PageInfo<Assets>> selectByPrimaryKey( Assets record) {

        JsonModel<PageInfo<Assets>> jsonModelList = new JsonModel<>();
        try {
            PageInfo<Assets> equipments = assetsService.selectByPrimaryKey(record);
            jsonModelList.setData(equipments);
            jsonModelList.setCode("0000");
            jsonModelList.setMsg("查询成功");
        }catch (Exception e){
            jsonModelList.setCode("404");
            jsonModelList.setMsg("查询失败");
        }
        return jsonModelList;
    }

    @GetMapping("/selectCountType")
    @ApiOperation(value = "获取资产总数，各类型数量", notes = "返回list，当需要事故类型数量时，资产类型可以是任意值")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "assetsType", value = "资产类型", defaultValue = "0",dataType = "String",
                    paramType = "query"),
    })
    public JsonModel<List<count>> selectCount(String assetsType) {
        JsonModel<List<count>> jsonModel = new JsonModel<>();
        try {
            jsonModel.setData(assetsService.selectCount(assetsType));
            jsonModel.setCode("0000");
            jsonModel.setMsg("查询成功");
        }catch (Exception e){
            jsonModel.setCode("404");
            jsonModel.setMsg("查询失败");
        }

        return jsonModel;
    }

}
