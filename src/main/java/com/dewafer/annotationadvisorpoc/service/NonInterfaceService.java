package com.dewafer.annotationadvisorpoc.service;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.dewafer.annotationadvisorpoc.annotation.CrossConcern;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class NonInterfaceService {

    private Random random = new Random();

    @CrossConcern
    public String helloWorld() {
        return "hello world!";
    }

    public void logging() {
        log.info("non-cross-concern method!");
    }

    @CrossConcern
    public void tryMe() {
        if (this.random.nextBoolean()) {
            log.info("Exception!");
            throw new RuntimeException("try me exception");
        } else {
            log.info("No exception.");
        }
    }
}
