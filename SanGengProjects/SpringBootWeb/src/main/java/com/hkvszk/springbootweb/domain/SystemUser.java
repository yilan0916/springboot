package com.hkvszk.springbootweb.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhengkang6
 * @date 2022/4/4
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SystemUser {

    private Integer id;
    private String username;
    private String password;
}
