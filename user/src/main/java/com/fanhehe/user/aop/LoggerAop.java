package com.fanhehe.user.aop;

import com.alibaba.fastjson.JSON;
import com.fanhehe.user.common.result.IResult;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author fanhehe
 */
@Aspect
@Component
public class LoggerAop {

    @Autowired
    private HttpServletRequest request;

    private static final Logger logger = LoggerFactory.getLogger(LoggerAop.class);

    @Pointcut("execution(* com.fanhehe.user..*(..))" +
            "&& (" +
            "@annotation(org.springframework.web.bind.annotation.RequestMapping)" +
            " || @annotation(org.springframework.web.bind.annotation.GetMapping)" +
            " || @annotation(org.springframework.web.bind.annotation.PostMapping))")
    public void handleController() {
    }

    @Around("handleController()")
    public Object handleMakeLogger(ProceedingJoinPoint pjp) throws Throwable {
        return handleMakeLogger(request, pjp);
    }

    private static Object handleMakeLogger(HttpServletRequest request, ProceedingJoinPoint pjp) throws Throwable {

        logger.info("开始执行");

        Object result = pjp.proceed();

        if (result instanceof IResult) {
            if (!((IResult) result).isSuccess()) {
                logger.info("请求结果 => {}", JSON.toJSONString(result));
            }
        }

        return result;
    }
}
