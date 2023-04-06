package com.example.highway_admin.interceptor;


import com.example.highway_admin.Utils.JWTUtil;
import com.example.highway_admin.Utils.JsonUtil;
import com.example.highway_admin.Utils.RSAUtil;
import com.github.pagehelper.util.StringUtil;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;

public class loginFilter implements HandlerInterceptor {

    private String publicKeyPath="D:/rsa.pub";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //检查请求
        if(request.getMethod().equalsIgnoreCase("options")){
            return true;
        }

        if(request.getRequestURI().endsWith("/login")){
            return true;
        }
        //怎么判断是否有登录
        //请求头中是否包含token
        //判断token是否有效
        //全部接口都要登录才能访问
        String token = request.getHeader("token");
        if(StringUtil.isEmpty(token)){
            cros(request,response);
            PrintWriter printWriter = response.getWriter();
            Map<String,Object> data = new HashMap<>();
            data.put("code",401);
            data.put("msg","没有登录");
            printWriter.print(JsonUtil.mapToJson(data));
            return false;
        }else{
            PublicKey publicKey = RSAUtil.getPublicKey(publicKeyPath);
            try{
                JWTUtil.getInfoFromToken(token,publicKey);
                return true;
            }catch (RuntimeException ex){
                cros(request,response);

                //说明token 无效
                PrintWriter printWriter = response.getWriter();
                Map<String,Object> data = new HashMap<>();
                data.put("code",401);
                data.put("msg","没有登录");

                printWriter.print(JsonUtil.mapToJson(data));
                return false;
            }
        }
    }


    private void cros(HttpServletRequest request,HttpServletResponse response){
        response.setContentType("application/json;charset=utf-8");

    }
}
