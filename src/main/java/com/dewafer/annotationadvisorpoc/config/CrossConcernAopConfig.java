package com.dewafer.annotationadvisorpoc.config;

import com.dewafer.annotationadvisorpoc.aop.CrossConcernAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class CrossConcernAopConfig {

    @Bean
    public CrossConcernAspect crossConcernAspect() {
        return new CrossConcernAspect();
    }
}
