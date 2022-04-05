package com.hkvszk.springbootweb.interceptor;

import com.hkvszk.springbootweb.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zhengkang6
 * @date 2022/4/4
 *
 * @Component注入容器
 * 登录拦截器
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {
    /**
     * 返回值为ture会放行，为false会拦截
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取请求头中的token
        String token = request.getHeader("token");
        //判断token是否为空，如果为空也代表未登录
        if (!StringUtils.hasText(token)) {
//            //错误代码401
//            response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            //异常统一处理
            throw new RuntimeException("未登录，请登录后重试");
            //抛出异常后下面的代码就不会执行了，所以要删掉
//            //拦截下来
//            return false;
        }
        //解析token看看是否成功
        try {

            //可能会抛出异常，选中语句，ctrl+alt+t，对语句增加try catch
            Claims claims = JwtUtil.parseJWT(token);
            String subject = claims.getSubject();
            System.out.println("解析器：" + subject);
        } catch (Exception e) {
            e.printStackTrace();
            //如果解析过程中没有出现异常说明是登录状态
            //如果出现的异常，说明未登录，提醒重新登录（401代码）
//            response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
//            return false;
            throw new RuntimeException("未登录，请登录后重试");
        }

        return true;
    }
}
