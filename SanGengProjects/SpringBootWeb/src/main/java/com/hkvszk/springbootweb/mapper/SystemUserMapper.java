package com.hkvszk.springbootweb.mapper;

import com.hkvszk.springbootweb.domain.SystemUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author zhengkang6
 * @date 2022/4/4
 */
@Mapper
@Repository
public interface SystemUserMapper {
    SystemUser login(SystemUser user);
}
