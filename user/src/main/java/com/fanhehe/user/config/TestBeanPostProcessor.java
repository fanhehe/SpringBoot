package com.fanhehe.user.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class TestBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

    private static Logger logger = LoggerFactory.getLogger(TestBeanPostProcessor.class);

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
//        logger.info(String.valueOf(2));
        return true;
    }

    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
//        logger.info(String.valueOf(3));
        return pvs;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//        logger.info(String.valueOf(4));
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//        logger.info(String.valueOf(5));
        return bean;
    }
}
