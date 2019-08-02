Spring Annotation Advisor Example
------

[![Build Status](https://travis-ci.org/dewafer/spring-annotation-advisor-example.svg?branch=master)](https://travis-ci.org/dewafer/spring-annotation-advisor-example)

Please follow the link for more detailed introduction in Chinese: [SpringBoot自定义注解切面](http://www.dewafer.com/2018/11/20/SpringBoot自定义注解切面/)

This example demonstrated 2 ways to implement Annotated Advisor for Beans in Spring boot project.

First is using `MethodInterceptor` through `BeanFactoryPointcutAdvisor` and `AbstractBeanFactoryAwareAdvisingPostProcessor`.

Second is using traditional `@Aspect`.

### The `MethodInterceptor` way

For the first implementation, please refer to [`CrossConcernConfig.java`](./src/main/java/com/dewafer/annotationadvisorpoc/config/CrossConcernConfig.java).

This is how Spring implement its `@Async` annotation.

### The AOP way

For the second implementation, please refer to [`CrossConcernAopConfig.java`](./src/main/java/com/dewafer/annotationadvisorpoc/config/CrossConcernAopConfig.java),
and [`CrossConcernAspect.java`](./src/main/java/com/dewafer/annotationadvisorpoc/aop/CrossConcernAspect.java).

This is the traditional AOP way.

### And?

This is a simple spring boot web application, you can start this application by running [`AnnotationAdvisorPocApplication`](./src/main/java/com/dewafer/annotationadvisorpoc/AnnotationAdvisorPocApplication.java) 
in any way you like.

2 endpoints are provided: `http://localhost:8080/` and `http://localhost:8080/exception`.

The call to the first endpoint will invoke a interface based business service `BusinessService` which has its default
implementation `BusinessServiceImpl`. This simple service will return current system time in `ISO_ZONED_DATE_TIME` format.

The call to the second endpoint will invoke a non-interface based business service `NonInterfaceService` which itself is
the default implementation. This simple service will thrown a runtime exception at random chance.

Both of the services have `CrossConcern` annotation on their methods, so the methods will be intercepted by 2 ways described above.

The `MethodInterceptor` way will do a simple try-catch-finally around the invocations and do simple logs at before, catch and finally stage of the invocation.

The Aop way has implemented before, after, afterReturning, afterThrowing and around advices for the method invocation and will do simple logs at each adivce.

