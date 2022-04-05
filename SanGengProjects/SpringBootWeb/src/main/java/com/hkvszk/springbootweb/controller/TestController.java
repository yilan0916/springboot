package com.hkvszk.springbootweb.controller;

import com.hkvszk.springbootweb.domain.ResponseResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author zhengkang6
 * @date 2022/4/4
 */
@RestController
public class TestController {
    @RequestMapping("/test")
    public String test() {
        return "test";
    }

    /**
     * 获取原生对象
     * @param request
     * @param response
     * @param session
     * @return
     */
    @RequestMapping("/getRequestAndResponse")
    public ResponseResult getRequestAndResponse(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        System.out.println(request);
        return new ResponseResult(200,"成功");
    }
}
