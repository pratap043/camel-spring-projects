package com.opentext.microservices.camelmicroservice.config;

import org.apache.camel.spring.javaconfig.CamelConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.opentext.microservices.camelmicroservice.routes")
public class MyRouteConfiguration extends CamelConfiguration {


}