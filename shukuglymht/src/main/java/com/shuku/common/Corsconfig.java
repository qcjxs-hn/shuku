package com.shuku.common;

import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

public class Corsconfig {
    //当前跨域请求最大有效时长
    private  static  final  long MAX_AGE= 24*60*60;
    private CorsConfiguration buildconfig(){
        CorsConfiguration corsConfiguration=new CorsConfiguration();
        //设置访问地址
        corsConfiguration.addAllowedOrigin("*");
        //设置访问头
        corsConfiguration.addAllowedHeader("*");
        //设置访问源请求方法
        corsConfiguration.addAllowedMethod("*");
        //设置时长
        corsConfiguration.setMaxAge(MAX_AGE);
        return corsConfiguration;

    }

    @Bean
    public void corsFilter(){
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        //对接口配置跨域
        source.registerCorsConfiguration("/**",buildconfig());

    }
}
