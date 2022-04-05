package com.hkvszk.springboottest;

import com.hkvszk.springboottest.controller.HelloController;
import com.hkvszk.springboottest.domain.User;
import com.hkvszk.springboottest.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author zhengkang6
 * @date 2022/4/3
 *
 * 注意：测试类所在的包需要和启动类是在同一个包下。否则就要使用如下写法指定启动类。
 * 如果不在同一包下，可以指定字节码对象：@SpringBootTest(classes = HelloApplication.class)
 *
 * springboot 2.2.0之前默认是Junit4
 * Junit5和Junit4使用方法不一样，Test所在包也不一样，Junit4需要在类上加上@RunWith(SpringRunner.class)才能自动注入成功
 */
@SpringBootTest
class SpringBootTestApplicationTests {

    /**
     * 测试是否能从容器当中获取到Controller对象，测试Service同样的写法
     */
    @Autowired
    private HelloController helloController;
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testJunit() {
        System.out.println(1);
        System.out.println(helloController); //输出helloController，看是否自动注入成功
    }

    @Test
    public void testMapper() {
        List<User> users = userMapper.findAll();
        System.out.println(users);  //list集合能够正常输出，说明mybatis整合好了
    }
}
