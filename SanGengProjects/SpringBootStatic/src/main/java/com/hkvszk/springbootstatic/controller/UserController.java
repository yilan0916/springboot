package com.hkvszk.springbootstatic.controller;

import com.hkvszk.springbootstatic.domain.User;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * @author zhengkang6
 * @date 2022/4/3
 */
@RestController
public class UserController {
    /**
     * 获取请求体中的Json格式参数,使用@RequestBody
     * Json格式：{"name":"三更","age":15}、{"name":"三更","age":15, "id":10087}
     * 封装成Map和封装成对象一样，修改为@RequestBody Map map
     * 注意：User里的各个属性顺序可以变，但名字必须一模一样
     * 如果需要使用@RequestBody来获取请求体中Json并且进行转换，要求请求头 Content-Type 的值要为： application/json 。
     */
    @RequestMapping(value = "/user", method = RequestMethod.POST, consumes = "application/json")
    public String insertUser(@RequestBody User user) {
        System.out.println("insertUser");
        System.out.println(user);
        return "insertUser";
    }
    /**
     * 如果请求体传递过来的数据是一个User集合转换成的json，Json数据可以这样定义：
     *   [{"name":"三更1","age":14},{"name":"三更2","age":15},{"name":"三更3","age":16}]
     */
    @RequestMapping(value = "/users", method = RequestMethod.POST, consumes = "application/json")
    public String insertUsers(@RequestBody List<User> users) {
        System.out.println("insertUser");
        System.out.println(users);
        return "insertUsers";
    }


    /**
     * 获取QueryString格式参数
     * 可以使用@RequestParam来获取QueryString格式的参数
     * 在方法中定义方法参数，方法参数名要和请求参数名一致，这种情况下我们可以省略@RequestParam注解。
     * 方法参数名要和请求参数名不一致且不使用@RequestParam，则无法获取相应的数据
     *
     * 也可以将id，name，likes封装成User对象，即修改为 testRequestParam(User user)
     * 测试时请求url如下：http://localhost:8080/testRequestParam?id=1&name=三更草堂&likes=编程&likes=录课&likes=烫头
     */
    @RequestMapping("/testRequestParam")
    public String testRequestParam(Integer id, String name, String[] likes){
        System.out.println("testRequestParam");
        System.out.println(id);
        System.out.println(name);
        System.out.println(Arrays.toString(likes));
        return "testRequestParam";
    }
    @RequestMapping("/testRequestParam10")
    public String testRequestParam10(User user){
        System.out.println("testRequestParam");
        System.out.println(user);
        return "testRequestParam";
    }
    /**
     * 如果方法参数名和请求参数名不一致，我们可以加上@RequestParam注解例如
     */
    @RequestMapping("/testRequestParam2")
    public String testRequestParam2(@RequestParam("id") Integer uid, @RequestParam("name") String name, @RequestParam("likes")String[] likes){
        System.out.println("testRequestParam2");
        System.out.println(uid);
        System.out.println(name);
        System.out.println(Arrays.toString(likes));
        return "testRequestParam2";
    }
    /**
     * QueryString格式,相关注解其他属性：required、defaultValue
     * required代表是否必须，默认值为true也就是必须要有对应的参数。如果没有就会报错。
     * 如果对应的参数没有，我们可以用defaultValue属性设置默认值。
     */
    @RequestMapping("/testRequestParam3")
    public String testRequestParam3(@RequestParam(value = "id",required = false,defaultValue = "777") Integer uid,@RequestParam("name") String name, @RequestParam("likes")String[] likes){
        System.out.println("testRequestParam3");
        System.out.println(uid);
        System.out.println(name);
        System.out.println(Arrays.toString(likes));
        return "testRequestParam3";
    }


}
