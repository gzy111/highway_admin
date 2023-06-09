package com.example.highway_admin.config;


import com.example.highway_admin.interceptor.loginFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//
@Configuration
public class myMvcConfig implements WebMvcConfigurer {

    Logger logger = LoggerFactory.getLogger(myMvcConfig.class);
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        WebMvcConfigurer.super.addInterceptors(registry);
        logger.info("注册拦截器");
        //下面是启用拦截器，拦截请求头没有token的请求
//        registry.addInterceptor(new loginFilter())
//                .addPathPatterns("/**")
//                .excludePathPatterns("/login/*","/swagger-ui.html/**","/swagger-resources/**","doc.html#/*");
    }


    @Override
    public void addCorsMappings(CorsRegistry registry) {
        /*
         * addMapping：配置可以被跨域的路径，可以任意配置，可以具体到直接请求路径。
         * allowCredentials：是否开启Cookie
         * allowedMethods：允许的请求方式，如：POST、GET、PUT、DELETE等。
         * allowedOrigins：允许访问的url，可以固定单条或者多条内容
         * allowedHeaders：允许的请求header，可以自定义设置任意请求头信息。
         * maxAge：配置预检请求的有效时间
         */

        WebMvcConfigurer.super.addCorsMappings(registry);
        registry.addMapping("/**")
                .allowedOriginPatterns("*")
                .allowCredentials(true)
                .allowedMethods("*")
                .allowedHeaders("*")
                .maxAge(36000);
    }
}
