package com.opentext.microservices.camelmicroservice.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringHelper implements ApplicationContextAware {

    private static final Log LOG = LogFactory.getLog(SpringHelper.class);

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        applicationContext = ctx;
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static <T> T getBean(String name, Class<T> type) {
        try {
            if (applicationContext == null) {
                LOG.warn("Failed to retrieve bean " + name + " as application context " +
                        "is not yet set");
                return null;
            }

            return applicationContext.getBean(name, type);
        } catch (Exception e) {
            LOG.error("We weren't able to resolve bean " + name +
                    " " + e.getMessage(), e);
            return null;
        }
    }

    public static Object getBean(String name) {
        try {
            if (applicationContext == null) {
                LOG.warn("Failed to retrieve bean " + name + " as application context " +
                        "is not yet set");
                return null;
            }

            return applicationContext.getBean(name);
        } catch (Exception e) {
            LOG.error("We weren't able to resolve bean " + name +
                    " " + e.getMessage(), e);
            return null;
        }
    }

}
