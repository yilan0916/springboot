package com.hkvszk.springbootweb.service;

import com.hkvszk.springbootweb.domain.User;

import java.util.List;

/**
 * @author zhengkang6
 * @date 2022/4/4
 *
 * ctrl+alt + 鼠标左键可以进行 实现类
 */
public interface UserService {
    List<User> findAll();

    void insertUser();
}
