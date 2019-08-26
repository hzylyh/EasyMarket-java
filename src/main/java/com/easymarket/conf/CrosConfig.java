package com.easymarket.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CrosConfig implements WebMvcConfigurer {

    @Autowired
    private MyInterceptor myInterceptor;

    @Value("${upload.path}")
    private String uploadPath;

    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*").allowedHeaders("*");
    }
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myInterceptor).addPathPatterns("/**").excludePathPatterns("/api/user/login")
                .excludePathPatterns("/api/upload/img")
                .excludePathPatterns("/api/user/register")
                .excludePathPatterns("/api/template/submit/form")
                .excludePathPatterns("/api/template/get/templateInfo")
                .excludePathPatterns("/api/template/visit")
                .excludePathPatterns("/upload/**")
                .excludePathPatterns("/error");
    }

    // 静态资源访问，主要是上传后的图片
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/upload/**").addResourceLocations("file:" + uploadPath);
    }
}
