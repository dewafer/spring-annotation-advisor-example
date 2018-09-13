package com.dewafer.annotationadvisorpoc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dewafer.annotationadvisorpoc.service.BusinessService;
import com.dewafer.annotationadvisorpoc.service.NonInterfaceService;

@RestController
public class HomeController {

    @Autowired
    private BusinessService businessServiceImpl;

    @Autowired
    private NonInterfaceService nonInterfaceService;

    @GetMapping("/")
    public String getHome() {
        this.nonInterfaceService.logging();
        return this.businessServiceImpl.getCurrentTime() + " " + this.nonInterfaceService.helloWorld();
    }

    @GetMapping("/exception")
    public String throwException() {
        this.nonInterfaceService.tryMe();
        return "no exception";
    }
    
}
