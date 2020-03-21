package com.fanhehe.home.config;

import com.fanhehe.home.Registry;
import com.fanhehe.home.system.IService;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.config.BeanPostProcessor;

@Component
public class ServiceRegistryPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        String a = bean.getClass().getSimpleName();

        if (bean instanceof IService) {
            Registry.addService("user", beanName, (IService)bean);
        }

        return bean;
    }
}
