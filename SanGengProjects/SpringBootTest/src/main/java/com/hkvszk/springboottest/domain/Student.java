package com.hkvszk.springboottest.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author zhengkang6
 * @date 2022/4/3
 *
 * lombok依赖和插件
 * @Data:会自动生成set，get方法
 * @NoArgsConstructor：自动生成空参构造
 * @AllArgsConstructor：自动生成全参构造
 * alt+7：能够给看见类里面的方法
 *
 * @Component：是把这个类交给Spring容器去管理
 * @ConfigurationProperties:prefix去指定yml文件里面对应的配置前缀
 * 注意事项：要求对应的属性要有set/get方法，并且key要和成员变量名一致才可以对应的上。
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@ConfigurationProperties(prefix = "student")
public class Student {
    private String name;
    private Integer age;
}
