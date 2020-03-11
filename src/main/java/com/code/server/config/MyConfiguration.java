package com.code.server.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
* 配置跨域访问，从配置文件中加载相关配置
*
*
* */
@Configuration
@EnableConfigurationProperties({ConfigBean.class})
public class MyConfiguration extends WebMvcConfigurationSupport {
    //获取配置文件中的数据
    @Autowired
    ConfigBean configBean;

   @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping(configBean.getAddMapping())
                .allowedOrigins(configBean.getAllowedOrigins())
                .allowedMethods(configBean.getAllowedMethods())
                .allowedHeaders(configBean.getAllowedHeaders())
                .exposedHeaders(configBean.getExposedHeaders())
                .allowCredentials(configBean.isAllowCredentials())
                .maxAge(configBean.getMaxAge());
    }

    @Override
    protected void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
//
        for(HttpMessageConverter<?> converter: converters){
            if(converter instanceof StringHttpMessageConverter){
                ((StringHttpMessageConverter)converter).setDefaultCharset(StandardCharsets.UTF_8);
            }
        }
    }
}
