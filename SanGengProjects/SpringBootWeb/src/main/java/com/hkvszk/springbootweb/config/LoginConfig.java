package com.hkvszk.springbootweb.config;

import com.hkvszk.springbootweb.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author zhengkang6
 * @date 2022/4/4
 */
//@Configuration
public class LoginConfig implements WebMvcConfigurer {

    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /**
         * registry.addInterceptor(loginInterceptor)//添加拦截器
         *             .addPathPatterns("/**")  //配置拦截路径
         *             .excludePathPatterns("/sys_user/login");//配置排除路径
         *
         * 加上拦截器之后访问http://localhost/test，会出现401，
         * 只有在headers中加上 key=token & value=eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIyYmE1ZWRjMy1hYWY4LTQ4OWMtOGI2OS0zMzMzMDJkNDY2MjUiLCJzdWIiOiIyIiwiaXNzIjoic2ciLCJpYXQiOjE2NDkwNzI2NTEsImV4cCI6MTY0OTA3NjI1MX0.WZT3jPTZbEXKhCOd2qEiPPixwcnjLbkJNGNAJ2DuePo
         * 才能正常访问http://localhost/test
         */
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/sys_user/login");
    }
}
