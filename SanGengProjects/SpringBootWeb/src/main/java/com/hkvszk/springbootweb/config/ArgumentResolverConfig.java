package com.hkvszk.springbootweb.config;

import com.hkvszk.springbootweb.resolver.UserIdArgumentResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @author zhengkang6
 * @date 2022/4/4
 */
@Configuration
public class ArgumentResolverConfig implements WebMvcConfigurer {

    @Autowired
    private UserIdArgumentResolver userIdArgumentResolver;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(userIdArgumentResolver);
    }
}
