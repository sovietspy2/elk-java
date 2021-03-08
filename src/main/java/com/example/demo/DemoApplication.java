package com.example.demo;

import com.example.demo.filter.LoggingFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public FilterRegistrationBean loadBalancerHealthCheckHandler() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new LoggingFilter());
        registration.addUrlPatterns("/*");
        return registration;
    }

}
