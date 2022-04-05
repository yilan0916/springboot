package com.hkvszk.springbootweb.service.impl;

import com.hkvszk.springbootweb.aop.InvokeLog;
import com.hkvszk.springbootweb.domain.User;
import com.hkvszk.springbootweb.mapper.UserMapper;
import com.hkvszk.springbootweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author zhengkang6
 * @date 2022/4/4
 *
 * 重写UserService，实现我们没有写的方法
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * @InvokeLog 会对这个方法进行增强
     */
    @Override
    @InvokeLog
    public List<User> findAll() {
        return userMapper.findAll();
    }

    /**
     * 直接在需要事务控制的方法上加上对应的注解@Transactional
     * @Transactional：声明式事务,两个增加记录，要么同时成功，要么同时失败
     */
    @Override
    @Transactional
    public void insertUser() {
        //添加2个用户到数据库
        User user = new User(null,"zk555",24,"hangzhou");
        User user2 = new User(null,"zk666",204,"beijing");
        userMapper.insertUser(user);
        //添加异常，只增加了上面的user，没有增加下面的user2
        System.out.println(1/0);
        userMapper.insertUser(user2);
    }
}
