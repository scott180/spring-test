package com.xu.spring.test.common.advice;

import com.alibaba.fastjson.JSON;
import com.xu.spring.test.common.Result;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author xu
 * @date 2020/1/11
 * https://www.cnblogs.com/moris5013/p/11026653.html
 * https://www.cnblogs.com/bigdataZJ/p/springboot-log.html
 */
@Aspect
@Component
@Order(1)
public class AdviceAspectLogConfig {

    private static final Logger logger = LoggerFactory.getLogger(AdviceAspectLogConfig.class);

    /**
     * 每种通配符表示的含义: | *表示任意字符  | ..表示本包和子包 或者是任意参数  |
     * 切入点：修饰符是public ,返回值任意类型，  service包和他的子包，以Service结尾的类，任意的方法
     */
    @Pointcut("execution(* com.xu.spring.test.*.*.*(..))")
    public void aroundMethod() {
    }


    /**
     * 可以在方法执行的前后添加非功能性的代码
     */
    @Around("aroundMethod()")
    public java.lang.Object aroundMethod(ProceedingJoinPoint joinPoint) {
        java.lang.Object result = null;
        try {
            logger.info("###被代理对象：{}", joinPoint.getTarget());
            java.lang.Object[] args = joinPoint.getArgs();
            logger.info("###参数：{}", JSON.toJSONString(args));
            result = joinPoint.proceed(joinPoint.getArgs());
        } catch (Throwable e) {
            System.out.println("###after throwing " + e);
            logger.info("###异常 Throwable ：{}", e);
            return Result.error(e.getMessage());
        } finally {
            logger.info("###返回结果：{}", JSON.toJSONString(result));
        }
        return result;
    }

}