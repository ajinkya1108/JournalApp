package com.ajinkya.journalApp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheck {
    @GetMapping
    String healthCheck()
    {
        return "OK";
    }
}
