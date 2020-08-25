package com.fanhehe.home.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserSystemAop {

    private static Logger logger = LoggerFactory.getLogger(UserSystemAop.class);

    UserSystemAop() {
        logger.info("xxxxxxxxxxxxxxxx");
    }

    @Pointcut("within(com.fanhehe.home.system.*)")
    public void handlePrint() {
    }

    @Before("handlePrint()")
    public void handleBeforePrint() {
        logger.info("====================");
    }
}
