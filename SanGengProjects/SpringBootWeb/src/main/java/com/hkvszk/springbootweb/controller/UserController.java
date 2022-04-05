package com.hkvszk.springbootweb.controller;

import com.hkvszk.springbootweb.domain.ResponseResult;
import com.hkvszk.springbootweb.domain.User;
import com.hkvszk.springbootweb.resolver.CurrentUserId;
import com.hkvszk.springbootweb.service.UserService;
import com.hkvszk.springbootweb.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author zhengkang6
 * @date 2022/4/4
 *
 * @CrossOrigin解决跨域请求：在相应头中看到Access-Control-Allow-Origin: *代表能访问
 * 位置：鼠标右键检查，在name里选择findAll，在选Network，在选Herders，就看见Response Herders了
 * @CrossOrigin可以加在类上也可以加载方法上
 */
@RestController
@RequestMapping("/user")
//@CrossOrigin
public class UserController {
    /**
     * 从容器中获取userService对象
     */
    @Autowired
    private UserService userService;

    @RequestMapping("/insertUser")
    public ResponseResult insertUser() {
        userService.insertUser();
        return new ResponseResult(200, "添加成功");
    }

//    @RequestMapping("/findAll")
//    public List<User> findAll() {
//        //调用service查询数据，进行返回
//        return userService.findAll();
//    }

//    @RequestMapping("/findAll")
//    public ResponseResult findAll() {
//        //调用service查询数据，进行返回
//        List<User> users = userService.findAll();
//        return new ResponseResult(200, users);
//    }

    /**
     * 使用自定义注解
     */
    @RequestMapping("/findAll")
    public ResponseResult findAll(@CurrentUserId String userId) throws Exception {
        //获取请求头中的token
//        String token = request.getHeader("token");
//        if (StringUtils.hasText(token)) {
//            //解析token获取用户id
//            Claims claims = JwtUtil.parseJWT(token);
//            String userId = claims.getSubject();
//            System.out.println("userId:" + userId);
//        }

        System.out.println(userId);
        //调用service查询数据，进行返回
        List<User> users = userService.findAll();
        return new ResponseResult(200, users);
    }
}
