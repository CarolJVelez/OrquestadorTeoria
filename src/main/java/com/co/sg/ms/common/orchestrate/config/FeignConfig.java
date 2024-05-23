package com.co.sg.ms.common.orchestrate.config;

import com.co.sg.ms.common.orchestrate.providers.codesa.services.AuthCodesaService;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.context.SecurityContextHolder;

@Configuration
public class FeignConfig {

    @Bean
    public RequestInterceptor requestInterceptor(AuthCodesaService authCodesaService) {
        return new RequestInterceptor() {
            @Override
            public void apply(RequestTemplate template) {
                String token = SecurityContextHolder.getContext().getAuthentication().getCredentials().toString();
                template.header("Authorization", "Bearer" + token);
            }
        };
    }
}
