package com.example.highway_admin.controller;

import com.example.highway_admin.Utils.JsonModel;
import com.example.highway_admin.base.count;
import com.example.highway_admin.base.countTable;
import com.example.highway_admin.domain.Case;
import com.example.highway_admin.service.CaseService;
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
@RequestMapping("/Case")
@Api(tags = "case", value = "案件接口")
public class CaseController {

    @Autowired
    CaseService caseService;


    @GetMapping("/delete")
    @ApiOperation(value = "删除案件", notes = "成功返回1")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "案件id",required = true,dataType = "integer"),
    })
    public JsonModel<Integer> deleteByPrimaryKey(Integer id) {
        JsonModel<Integer> jsonModel = new JsonModel<>();
        try {
            jsonModel.setData(caseService.deleteByPrimaryKey(id));
            jsonModel.setCode("0000");
            jsonModel.setMsg("删除成功");
        }catch (Exception e){
            jsonModel.setCode("404");
            jsonModel.setMsg("删除失败");
        }
        return jsonModel;
    }




    @ApiOperation(value = "添加案件", notes = "成功返回1")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "detailedType", value = "事故类型",dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "caseType", value = "案件类型",dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "state", value = "状态",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "user", value = "处理员工", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "caseName", value = "案件名称", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "data", value = "案件信息", dataType = "String", paramType = "query"),
    })
    @PostMapping("/insert")
    public JsonModel<Integer>  insertSelective( @RequestBody Case record) {
        System.out.println(record);
        JsonModel<Integer> jsonModel = new JsonModel<>();
        try {
            record.setCreateTime(new Date());
            record.setId(caseService.selectMaxID()+1);
            record.setState("2");
            jsonModel.setData(caseService.insertSelective(record));
            jsonModel.setCode("0000");
            jsonModel.setMsg("添加成功");
        }catch (Exception e){
            jsonModel.setCode("404");
            jsonModel.setMsg("添加失败");
        }
        return jsonModel;
    }



    @PutMapping("/updateById")
    @ApiOperation(value = "更新案件", notes = "成功返回1")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "案件id",required = true,defaultValue = "",dataType = "integer", paramType = "query"),
            @ApiImplicitParam(name = "detailedType", value = "事故类型",dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "caseType", value = "案件类型",dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "state", value = "状态", required = true,dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "user", value = "处理员工", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "caseName", value = "案件名称", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "data", value = "案件信息", dataType = "String", paramType = "query"),
    })
    public JsonModel<Integer> updateByPrimaryKeySelective(Case record) {
        JsonModel<Integer> jsonModel = new JsonModel<>();
        try {
            if (record.getState().equals("0")){
                record.setProcessingTime(new Date());
            }else if(record.getState().equals("1")){
                record.setFinishTime(new Date());
            }

            jsonModel.setData(caseService.updateByPrimaryKeySelective(record));
            jsonModel.setCode("0000");
            jsonModel.setMsg("更新成功");
        }catch (Exception e){
            jsonModel.setCode("404");
            jsonModel.setMsg("更新失败");
        }

        return jsonModel;
    }



    @GetMapping("selectAll")@ApiOperation(value = "查询所有案件不分页", notes = "查询所有案件不分页")
    public List<Case> selectByPrimaryKey() {
        return caseService.selectByPrimaryKey();
    }

    @GetMapping("/selectPageInfo")
    @ApiOperation(value = "获取案件列表", notes = "返回list，user可以模糊查找")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "案件id",defaultValue = "",dataType = "integer", paramType = "query"),
            @ApiImplicitParam(name = "detailedType", value = "事故类型",dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "caseType", value = "案件类型",dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "state", value = "状态",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "user", value = "处理员工", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "pageNum", value = "页数", defaultValue = "1",dataType = "integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "一页多少条", defaultValue = "10",dataType ="integer", paramType = "query"),
    })
    public JsonModel<PageInfo<Case>> selectByPrimaryKey(Case record) {
        System.out.println(record);
        PageInfo<Case> equipments = caseService.selectByPrimaryKey(record);
        JsonModel<PageInfo<Case>> jsonModelList = new JsonModel<>();
        jsonModelList.setData(equipments);
        jsonModelList.setCode("0000");
        jsonModelList.setMsg("查询成功");
        return jsonModelList;
    }

    @GetMapping("/selectCountType")
    @ApiOperation(value = "获取案件总数，各类型数量", notes = "返回list，当需要事故类型数量时，detailedType可任意传入值,当不传入任何值时，所获取count为所有案件数量")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "caseType", value = "案件类型", defaultValue = "事故",dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "detailedType", value = "事故类型", defaultValue = "0",dataType = "String", paramType = "query")
    })
    public JsonModel<List<Case>> selectCountType(@RequestParam(value = "caseType", required = false) String caseType,
                                                 @RequestParam(value = "detailedType", required = false)String detailedType ) {
        JsonModel<List<Case>> jsonModel = new JsonModel<>();
        System.out.println(caseType+"  "+detailedType);
        Case record= new Case();
        try {
            if (!caseType.equals(null)){
                record.setCaseType(caseType);
                System.out.println("tpye");
            }
        }catch (Exception e){
        }
       try {
           if (!detailedType.equals(null)){
               record.setDetailedType(detailedType);
               System.out.println("de");
           }
       }catch (Exception e){
       }

        System.out.println(record);
        try{
            List<Case> list = caseService.selectCountType(record);
            jsonModel.setCode("0000");
            jsonModel.setData(list);
            jsonModel.setMsg("查询成功");
        }catch (Exception e){
            jsonModel.setMsg("出现异常");
            jsonModel.setCode("404");
        }

        return jsonModel;
    }

    @GetMapping("/selectCount")
    @ApiOperation(value = "获取案件总数", notes = "返回list，当需要事故类型数量时，detailedType可任意传入值,当不传入任何值时，所获取count为所有案件数量")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "caseType", value = "案件类型", defaultValue = "0",dataType = "String", paramType =
                    "query"),
    })
    public JsonModel<List<count>> selectCount(String caseType) {
        JsonModel<List<count>> jsonModel = new JsonModel<>();
        try {
            jsonModel.setData(caseService.selectCount(caseType));
            jsonModel.setCode("0000");
            jsonModel.setMsg("查询成功");
        }catch (Exception e){
            jsonModel.setCode("404");
            jsonModel.setMsg("查询失败");
        }

        return jsonModel;
    }

}
