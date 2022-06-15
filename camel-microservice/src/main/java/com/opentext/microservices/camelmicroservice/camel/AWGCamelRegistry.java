package com.opentext.microservices.camelmicroservice.camel;

import org.apache.camel.support.DefaultRegistry;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Component
public class AWGCamelRegistry extends DefaultRegistry implements ApplicationContextAware {
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public Object lookupByName(String name) {
        try {
            return applicationContext.getBean(name);
        }
        catch (NoSuchBeanDefinitionException e) {
            return null;
        }
    }

    @Override
    public <T> Map<String, T> findByTypeWithName(Class<T> type) {
        return applicationContext.getBeansOfType(type);
    }

    @Override
    public <T> T lookupByNameAndType(String name, Class<T> type) {
        try {
            return applicationContext.getBean(name, type);
        }
        catch (NoSuchBeanDefinitionException e) {
            return null;
        }
    }

    @Override
    public <T> Set<T> findByType(Class<T> type) {
        Set<T> ret = new HashSet<T>();
        applicationContext.getBeansOfType(type).entrySet().forEach(entry -> ret.add(type.cast(entry.getValue())));
        return ret;
    }

    public Object lookup(String name) {
        return lookupByName(name);
    }

    public <T> T lookup(String name, Class<T> type) {
        return lookupByNameAndType(name, type);
    }

    public <T> Map<String, T> lookupByType(Class<T> type) {
        return this.findByTypeWithName(type);
    }
}
