package com.hkvszk.springbootstatic.controller;

import org.springframework.web.bind.annotation.*;

/**
 * @author zhengkang6
 * @date 2022/4/3
 *
 * 类路径就是java包或者resource包下
 */
@RestController
@RequestMapping("/test")
public class HelloController {
    /**
     * @RequestMapping既可以加在方法上，又可以加在类上
     * 由于类上也有@RequestMapping,所有访问路径修改为了http://localhost:8080/test/hello
     * 如果@RequestMapping有多个值，需要写 value 和 method 和 params 和 headers 和 consumes
     *
     * @RequestMapping("/hello")
     * @RequestMapping(value = "/hello", method = RequestMethod.GET)
     * @GetMapping("/hello")
     * - @PostMapping    等价于   @RequestMapping(method = RequestMethod.POST)
     * - @GetMapping    等价于   @RequestMapping(method = RequestMethod.GET)
     * - @PutMapping    等价于   @RequestMapping(method = RequestMethod.PUT)
     * - @DeleteMapping    等价于   @RequestMapping(method = RequestMethod.DELETE)
     *
     * params = "code"、params = "!code"、params = "code=sgct"、params = "code!=sgct"
     * headers = "deviceType"、headers = "!deviceType"、headers = "deviceType=ios"、headers = "deviceType!=ios"
     * consumes = "multipart/from-data"、consumes = "!multipart/from-data"  我们可以使用**consumes**属性来对**Content-Type**这个请求头进行一些限制。
     * @return
     */
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

//    我们期望让请求的资源路径为**/test/testConsumes**的POST请求,并且请求头中的Content-Type头必须为 multipart/from-data 的请求能够被testConsumes方法处理。则可以写如下代码

    @RequestMapping(value = "/testConsumes", method = RequestMethod.POST, consumes = "multipart/from-data")
    public String testConsumes() {
        System.out.println("testConsumes处理了请求");
        return "testConsumes";
    }

    /**
     * 获取请求参数有三种，@PathVariable 和 @RequestBody 还有QueryString格式的@RequestParam，前者处理短的，后者处理json格式的，QueryString格式：/user?name=zk&age=18
     * 注意：方法参数上的命名可以与@PathVariable不同，例如：Integer userid
     * @RequestBody：见UserController
     * QueryString格式:见UserController
     */
    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public String findUserById( @PathVariable("id")Integer uid){
        System.out.println("findUserById");
        System.out.println(uid);
        return "findUserById";
    }
    @RequestMapping(value = "/user/{id}/{name}",method = RequestMethod.GET)
    public String findUser(@PathVariable("id") Integer id,@PathVariable("name") String name){
        System.out.println("findUser");
        System.out.println(id);
        System.out.println(name);
        return "findUser";
    }

}
