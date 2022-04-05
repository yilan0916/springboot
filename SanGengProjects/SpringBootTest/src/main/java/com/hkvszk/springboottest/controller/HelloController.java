package com.hkvszk.springboottest.controller;

import com.hkvszk.springboottest.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author zhengkang6
 * @date 2022/4/3
 *
 * @Controller
 * @ResponseBody：见hello（）
 * @RestController=@Controller+@ResponseBody
 */
@RestController
public class HelloController {

    /**
     * SpringBoot读取YML有两种方法，一种是@Value注解，另一种是@ConfigurationProperties
     * @Value注解：注意使用此注解只能获取简单类型的值（8种基本数据类型及其包装类，String,Date）
     * 注意：加了@Value的类必须是交由Spring容器管理的
     * 八种基本数据类型分别是：int、short、float、double、long、boolean、byte、char
     */
    @Value("${name}")
    private String name;
    @Value("${date}")
    private Date date;
    @Value("${student.age}")
    private Integer age;

    /**
     * @ConfigurationProperties注解：见Student.java文件
     * @Autowired:自动注入
     * YML和properties配置的相互转换：https://www.toyaml.com/index.html
     */
    @Autowired
    private Student stu;




    /**
     * /hello 是访问地址
     * 类方法上已有 @ResponseBody，所以方法上的可以省略不屑了
     * //    @ResponseBody
     * @return
     */
    @RequestMapping("/hello")
    public String hello() {
        /**
         * 如果直接返回字符串，在springmvc情况下，默认是进行页面跳转的。若不想跳转，只想让它在相应体中，在方法名上加@ResponseBody
         * 若Controller里的所有方法都在响应体中，不必在所以方法上加@ResponseBody。做一个小优化，在类上面加即可
         */
        return "Hello Spring Boot！";
    }

    @RequestMapping("/test")
    public String test() {
        System.out.println(name);
        return "testValue";
    }

}
