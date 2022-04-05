package com.hkvszk.springbootweb.service.impl;

import com.hkvszk.springbootweb.domain.SystemUser;
import com.hkvszk.springbootweb.mapper.SystemUserMapper;
import com.hkvszk.springbootweb.service.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhengkang6
 * @date 2022/4/4
 */
@Service
public class SystemUserServiceImpl implements SystemUserService {

    @Autowired
    private SystemUserMapper systemUserMapper;
    @Override
    public SystemUser login(SystemUser user) {
        SystemUser loginUser = systemUserMapper.login(user);
        return loginUser;
    }
}
