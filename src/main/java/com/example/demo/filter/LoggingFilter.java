package com.example.demo.filter;

import com.example.demo.aspect.LogAspect;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.slf4j.MDC;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoggingFilter implements javax.servlet.Filter {

    private static final Logger logger =  LogManager.getLogger(LogAspect.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        filterChain.doFilter(servletRequest, servletResponse);
        MDC.put("status",String.valueOf(httpServletResponse.getStatus()));
        logger.info("API endpoint access "+String.valueOf(httpServletResponse.getStatus()));
    }

}
