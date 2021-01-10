package com.oracle.application.filter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class FilterConfig {
      @Bean
      public FilterRegistrationBean<FilterDemo> filterDemoFilterRegistrationBean(){
          FilterRegistrationBean register = new FilterRegistrationBean();
          register.setFilter(new FilterDemo());
          //添加过滤的请求，可多个请求
          register.addUrlPatterns("/admins/*");
          return register;

      }
}
