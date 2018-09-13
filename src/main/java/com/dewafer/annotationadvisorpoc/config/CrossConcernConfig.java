package com.dewafer.annotationadvisorpoc.config;

import org.aopalliance.intercept.MethodInterceptor;
import org.springframework.aop.framework.autoproxy.AbstractBeanFactoryAwareAdvisingPostProcessor;
import org.springframework.aop.support.DefaultBeanFactoryPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dewafer.annotationadvisorpoc.annotation.CrossConcern;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
//@EnableAsync
public class CrossConcernConfig {

    //    @Bean
    //    public DefaultPointcutAdvisor crossConcernAdvisor() {
    //        return new DefaultPointcutAdvisor(AnnotationMatchingPointcut.forMethodAnnotation(CrossConcern.class),
    //                (MethodInterceptor) invocation -> {
    //                    log.info("before invocation: {}", invocation);
    //                    try {
    //                        return invocation.proceed();
    //                    } catch (Throwable e) {
    //                        log.info("exception thrown", e);
    //                        throw e;
    //                    } finally {
    //                        log.info("after invocation: {}", invocation);
    //                    }
    //                });
    //    }

    @Bean
    public MethodInterceptor loggingMethodInterceptor() {
        return invocation -> {
            log.info("before invocation: {}", invocation);
            try {
                return invocation.proceed();
            } catch (Throwable e) {
                log.info("exception thrown", e);
                throw e;
            } finally {
                log.info("after invocation: {}", invocation);
            }
        };
    }

    @Bean
    public DefaultBeanFactoryPointcutAdvisor advisor() {
        DefaultBeanFactoryPointcutAdvisor advisor = new DefaultBeanFactoryPointcutAdvisor();
        advisor.setPointcut(AnnotationMatchingPointcut.forMethodAnnotation(CrossConcern.class));
        advisor.setAdvice(loggingMethodInterceptor());
        return advisor;
    }

    @Bean
    public AbstractBeanFactoryAwareAdvisingPostProcessor advisingPostProcessor() {
        return new AbstractBeanFactoryAwareAdvisingPostProcessor() {
            {
                this.advisor = advisor();
            }
        };
    }

    //    @Bean
    //    public CrossConcernAnnotationBeanPostProcessor beanPostProcessor() {
    //        return new CrossConcernAnnotationBeanPostProcessor();
    //    }

    //    public static class CrossConcernAnnotationBeanPostProcessor extends AbstractBeanFactoryAwareAdvisingPostProcessor {
    //        @Override public void setBeanFactory(BeanFactory beanFactory) {
    //            super.setBeanFactory(beanFactory);
    //
    //            DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor(
    //                    AnnotationMatchingPointcut.forMethodAnnotation(CrossConcern.class),
    //                    (MethodInterceptor) );
    //
    //            this.advisor = advisor;
    //        }
    //    }

}
