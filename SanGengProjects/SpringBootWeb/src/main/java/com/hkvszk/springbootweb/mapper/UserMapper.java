package com.hkvszk.springbootweb.mapper;

import com.hkvszk.springbootweb.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhengkang6
 * @date 2022/4/4
 */
@Mapper
@Repository
public interface UserMapper {
    List<User> findAll();

    void insertUser(User user);
}
