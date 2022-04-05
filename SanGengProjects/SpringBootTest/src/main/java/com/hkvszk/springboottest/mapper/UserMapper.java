package com.hkvszk.springboottest.mapper;

import com.hkvszk.springboottest.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author zhengkang6
 * @date 2022/4/3
 *
 * @Mapper注解：加上让Mybatis识别
 * @Repository 可加可不加。如果userMapper报错，加上可以消除warning，放入spring容器中。但是userMapper是mybatis帮我们写的
 *
 * 1、鼠标放在UserMapper上 alt+enter，选择[MybatisX] Generate mapper of xml
 * 2、选择findAll方法，alt+enter，选择Generate statement
 */
@Mapper
public interface UserMapper {
    public List<User> findAll();
}
