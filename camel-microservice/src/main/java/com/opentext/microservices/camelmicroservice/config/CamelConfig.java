package com.opentext.microservices.camelmicroservice.config;


import org.apache.camel.spring.javaconfig.CamelConfiguration;
import org.apache.camel.support.DefaultRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.opentext.microservices.camelmicroservice.camel.AWGCamelRegistry;
import com.opentext.microservices.camelmicroservice.routes.CamelRouterApp;

@Configuration
public class CamelConfig {

    @Bean
    public DefaultRegistry awgCamelRegistry() {
        return new AWGCamelRegistry();
    }
    
	
	/*
	 * @Bean public CamelRouterApp camelRouteBuilder() { return new
	 * CamelRouterApp(); }
	 */
	/*
	 * @Bean public CamelConfiguration camelConfiguration() { return new
	 * MyRouteConfiguration(); }
	 */
    
	/*
	 * @Bean public SpringHelper springHelper() { return new SpringHelper(); }
	 */
    
}
