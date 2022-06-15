package com.opentext.microservices.camelmicroservice;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

import com.opentext.microservices.camelmicroservice.config.CamelConfig;
import com.opentext.microservices.camelmicroservice.config.MyRouteConfiguration;

public class MainApp {
   public static void main(String[] args) {
      ApplicationContext ctx = 
         new AnnotationConfigApplicationContext(MyRouteConfiguration.class, CamelConfig.class);
   }
}