package com.neu;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.neu.SimpleCORSFilter;
import org.springframework.web.filter.CharacterEncodingFilter;


/**
 * @author hWX585378
 * @date 2018年8月21日
 */
@Configuration
public class WebConfig {
    private static final String allowMethods = "GET,POST,PUT,DELETE,OPTIONS";
    private static final String allowOrigin = "http://localhost:8080";
    private static final String allowCredentials = "true";
    private static final String allowHeaders = "Content-Type,X-Token";

    @Bean
    public FilterRegistrationBean loginFilterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setName("CorsFilter");
        filterRegistrationBean.setFilter(new SimpleCORSFilter());
        filterRegistrationBean.addInitParameter("allowMethods", allowMethods);
        filterRegistrationBean.addInitParameter("allowOrigin", allowOrigin);
        filterRegistrationBean.addInitParameter("allowCredentials", allowCredentials);
        filterRegistrationBean.addInitParameter("allowHeaders", allowHeaders);
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.setOrder(1);
        return filterRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean(){

        //创建一个spring提供的过滤器
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        //强制编码
        characterEncodingFilter.setForceEncoding(true);
        characterEncodingFilter.setEncoding("UTF-8");

        //filter注册bean
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(characterEncodingFilter);
        //要过滤的路径
        registrationBean.addUrlPatterns("/*");
        return registrationBean;
    }
}

