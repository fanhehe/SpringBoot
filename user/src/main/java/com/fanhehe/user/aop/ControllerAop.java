package com.fanhehe.user.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ControllerAop {

    ControllerAop() {
        logger.info("xxxxx");
    }

    private static Logger logger = LoggerFactory.getLogger(ControllerAop.class);

    @Pointcut("within(com.fanhehe.user.controller.*)")
    public void handleLog() {}

    @Before("handleLog()")
    public void handlePrint() {
        logger.info("====================");
    }
}
