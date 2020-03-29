package org.wtm.logistics.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.wtm.logistics.converter.DateConverter;

@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {
     @Override
     public void addFormatters(FormatterRegistry registry) {
         registry.addConverter(new DateConverter());
     }
 }
