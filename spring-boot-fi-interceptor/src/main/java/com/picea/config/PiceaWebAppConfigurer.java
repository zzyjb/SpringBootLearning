package com.picea.config;

import com.picea.interceptor.PiceaInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * <p>PiceaWebAppConfigurer</p>
 * <p>description.</p>
 *
 * @author : jiangbing.yang
 * @version 0.1
 * @date : 2019/4/18 9:21
 * @company :
 */
@Configuration
public class PiceaWebAppConfigurer implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authenticationInterceptor())//增加过滤的方法类
                .addPathPatterns("/**");//定义过滤的范围
    }

    @Bean
    public PiceaInterceptor authenticationInterceptor() {
        return new PiceaInterceptor();
    }
}
