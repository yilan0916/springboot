package com.hkvszk.springbootweb.service;

import com.hkvszk.springbootweb.domain.SystemUser;

/**
 * @author zhengkang6
 * @date 2022/4/4
 */
public interface SystemUserService {
    public SystemUser login(SystemUser user);
}
