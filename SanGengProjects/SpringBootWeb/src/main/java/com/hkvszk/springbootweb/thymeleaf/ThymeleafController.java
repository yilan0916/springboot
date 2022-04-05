package com.hkvszk.springbootweb.thymeleaf;

import com.hkvszk.springbootweb.domain.User;
import com.hkvszk.springbootweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author zhengkang6
 * @date 2022/4/5
 *
 * 模板引擎要跳转的，不能使用@RestController
 * 模板引擎需要复制一下前端项目的static和html到templates中
 */
@Controller
public class ThymeleafController {

    @Autowired
    private UserService userService;

    @RequestMapping("/thymeleaf/users")
    public String users(Model model) {
        //获取数据
        List<User> users = userService.findAll();
        //往域中存入数据
        model.addAttribute("users", users);
        model.addAttribute("msg","hello thymeleaf");
        //页面跳转
        return "table-standard";
    }
}
