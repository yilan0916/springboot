package com.hkvszk.springbootweb;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
class SpringBootWebApplicationTests {

    @Autowired
    private StringRedisTemplate redisTemplate;

//    未完成redis的整合
    @Test
    void testRedis() {
        redisTemplate.opsForValue().set("name","三更");
    }
//    获取对应的值
    @Test
    void testRedisGetValue() {
        String name = redisTemplate.opsForValue().get("name");
        System.out.println(name);
    }
}
