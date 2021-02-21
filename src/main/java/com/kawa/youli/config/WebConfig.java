package com.kawa.youli.config;

import com.kawa.youli.util.IPUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
 
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        if (IPUtil.isWindowsOS()) {  //如果是Windows系统
            registry.addResourceHandler("/headShot/**").addResourceLocations("file:D:/static/pic/headShot/");
            registry.addResourceHandler("/strategyPic/**").addResourceLocations("file:D:/static/pic/strategy/");
            registry.addResourceHandler("/giftPic/**").addResourceLocations("file:D:/static/pic/gift/");
        }else{//linux和mac系统
            registry.addResourceHandler("/headShot/**").addResourceLocations("file:/static/pic/headShot/");
            registry.addResourceHandler("/strategyPic/**").addResourceLocations("file:/static/pic/strategy/");
            registry.addResourceHandler("/giftPic/**").addResourceLocations("file:/static/pic/gift/");
        }
    }
}