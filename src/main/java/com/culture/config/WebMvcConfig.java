package com.culture.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*
WebMvcConfigurer
    스프링 MVC를 위해 자바기반의 구성설정을 도와주는 유틸리티 인터페이스
*/
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Value("${uploadPath}") // application.properties에 적혀있음
    String uploadPath ;

    @Override // 이 메소드는 정적 자원(images, js and css 등등)들을 서비스해주기 위한 기능을 수행합니다.
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        // "/images"으로 시작하는 요청이 들어 오는 경우 uploadPath에 설정된 폴더를 기준으로 읽어 들이겠습니다.
//        // addResourceLocations() : 내 컴퓨터에서 저장된 파일을 읽어 들일 root 경로를 지정
        registry.addResourceHandler("/images/**").addResourceLocations(uploadPath) ;
    }
}
