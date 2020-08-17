package com.example.bug_tracker.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true);
    }

    /*@Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/** ** ")
                .addResourceLocations("/frontend/build/static/");
        registry.addResourceHandler("/** .js")
                .addResourceLocations("/frontend/build/");
        registry.addResourceHandler("/** .json")
                .addResourceLocations("/frontend/build/");
        registry.addResourceHandler("/** .ico")
                .addResourceLocations("/frontend/build/");
        registry.addResourceHandler("/index.html")
                .addResourceLocations("/frontend/build/index.html");
    }
     */
}
