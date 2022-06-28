package com.culture.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration // 설정을 위한 클래스
@EnableJpaAuditing // Jpa 감사용 파일
public class AuditConfig {
    @Bean // 객체화
    public AuditorAware<String> auditorProvider(){
        return new AuditorAwareImpl();
    }
}
