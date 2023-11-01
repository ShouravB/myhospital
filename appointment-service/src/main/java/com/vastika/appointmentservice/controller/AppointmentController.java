package com.vastika.appointmentservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1")
public class AppointmentController {

    @GetMapping(value = "/ping")
    public String ping(){
        return "UP";
    }

}
