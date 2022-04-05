package com.hkvszk.springbootstatic.controller;

import com.hkvszk.springbootstatic.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zhengkang6
 * @date 2022/4/4
 */
@Controller
@RequestMapping("/response")
public class ResponseController {
    /**
     * 响应体响应数据,无论是RestFul风格还是我们之前web阶段接触过的异步请求，都需要把数据转换成Json放入响应体中。
     * 数据放到响应体,我们的SpringMVC为我们提供了**@ResponseBody**来非常方便的把Json放到响应体中。
     * @ResponseBody可以加在哪些东西上面？类上和方法上
     * 数据转换成Json
     */

    /**
     * 要求定义个RestFul风格的接口，该接口可以用来根据id查询用户。请求路径要求为  /response/user  ，请求方式要求为GET。
     * 而请求参数id要写在请求路径上，例如   /response/user/1   这里的1就是id。
     * 要求获取参数id,去查询对应id的用户信息（模拟查询即可，可以选择直接new一个User对象），并且转换成json响应到响应体中。
     */
    @RequestMapping("/user/{id}")
    @ResponseBody
    public User findById(@PathVariable("id") Integer id){
        User user = new User(id, "三更草堂", 15, null);
        return user;
    }
}
