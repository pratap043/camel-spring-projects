package com.opentext.microservices.camelmicroservice.routes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.support.DefaultRegistry;
import org.springframework.stereotype.Component;

import com.opentext.microservices.camelmicroservice.config.SpringHelper;

@Component
public class CamelRouterApp extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		
		DefaultCamelContext defContext = (DefaultCamelContext) getContext();
		defContext.setRegistry(SpringHelper.getBean("awgCamelRegistry", DefaultRegistry.class));
		 
		from("timer:First-Timer")
		.to("log:Hi Welcome !!");
		
	}

}