package com.dewafer.annotationadvisorpoc.service;

import org.springframework.stereotype.Service;

import com.dewafer.annotationadvisorpoc.annotation.CrossConcern;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class NonInterfaceService {

    @CrossConcern
    public String helloWorld() {
        return "hello world!";
    }

    public void logging() {
        log.info("non-cross-concern method!");
    }
}
