package com.example.highway_admin.controller;


import com.example.highway_admin.Utils.JsonModel;
import com.example.highway_admin.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileSystemUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;


@RestController
@RequestMapping("/File")
public class FileUploadController {

    @Autowired
    UserService userService;

    @PostMapping("/UploadFile")
    @ResponseBody
    //将上传的文件放在tomcat目录下面的file文件夹中
    public JsonModel<String> upload(@RequestParam("file") MultipartFile multipartFile, HttpServletRequest request,
                                     HttpServletResponse response) throws IOException {
        JsonModel<String> jsonModel = new JsonModel<>();
        //获取到原文件全名
        String originalFilename = multipartFile.getOriginalFilename();
        // request.getServletContext()。getRealPath("")这里不能使用这个，这个是获取servlet的对象，并获取到的一个临时文件的路径，所以这里不能使用这个
        //这里获取到我们项目的根目录，classpath下面
        String realPath = ResourceUtils.getFile("classpath:").getPath();
        System.out.println(realPath+" rel");
        String path = realPath + "/static/img/";
        //判断文件夹是否存在，存在就不需要重新创建，不存在就创建
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        String filePath=realPath+"static/img/"+originalFilename;
        System.out.println(filePath);
        if (new File(filePath).exists()){
            jsonModel.setCode("404");
            jsonModel.setMsg("文件已经存在");
            System.out.println("文件存在");
            return jsonModel;
        }
        //转换成对应的文件存储，new File第一个参数是目录的路径，第二个参数是文件的完整名字
        multipartFile.transferTo(new File(file, originalFilename));
        //上传文件的全路径
        String url =
                request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/img/" + originalFilename;
        System.out.println(url+"   url");
        jsonModel.setData(url);
        return jsonModel;

    }



}