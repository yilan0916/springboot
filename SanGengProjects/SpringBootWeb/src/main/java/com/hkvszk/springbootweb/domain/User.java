package com.hkvszk.springbootweb.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhengkang6
 * @date 2022/4/3
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private  Integer id;
    private String username;
    private  Integer age;
    private  String address;
}
