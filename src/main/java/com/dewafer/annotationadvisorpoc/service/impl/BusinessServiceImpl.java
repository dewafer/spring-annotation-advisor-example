package com.dewafer.annotationadvisorpoc.service.impl;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;

import com.dewafer.annotationadvisorpoc.annotation.CrossConcern;
import com.dewafer.annotationadvisorpoc.service.BusinessService;

@Service
public class BusinessServiceImpl implements BusinessService {

    @CrossConcern
    public String getCurrentTime() {
        return DateTimeFormatter.ISO_ZONED_DATE_TIME.format(ZonedDateTime.now());
    }

}
