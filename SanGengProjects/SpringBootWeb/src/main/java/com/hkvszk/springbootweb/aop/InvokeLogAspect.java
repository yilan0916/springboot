package com.hkvszk.springbootweb.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * @author zhengkang6
 * @date 2022/4/4
 *
 * @Aspect用来标识这是一个切面类
 */
@Aspect
@Component
public class InvokeLogAspect {
    /**
     * 确定切点
     */
    @Pointcut("@annotation(com.hkvszk.springbootweb.aop.InvokeLog)")
    public void pt() {

    }

    @Around("pt()")
    public Object printInvokeLog(ProceedingJoinPoint joinPoint) {
        //目标方法调用前
        Object proceed = null;
//        Signature signature = joinPoint.getSignature();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String methodName = signature.getMethod().getName();
        System.out.println(methodName+"即将被调用");
        try {
            proceed = joinPoint.proceed();
            //目标方法调用后
            System.out.println(methodName+"被调用完了");
        } catch (Throwable e) {
            e.printStackTrace();
            //目标方法出现了异常
            System.out.println(methodName+"出现了异常");
        }
        return proceed;
    }
}
