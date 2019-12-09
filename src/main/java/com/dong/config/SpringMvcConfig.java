package com.dong.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 3hld
 * @date 2019/12/9 10:15
 * @Version 1.0
 */
@Configuration
public class SpringMvcConfig implements WebMvcConfigurer {

    /**
     * 添加资源处理
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/view/**").addResourceLocations("/WEB-INF/view/");
        registry.addResourceHandler("/page/**").addResourceLocations("/WEB-INF/page/");
    }
}
