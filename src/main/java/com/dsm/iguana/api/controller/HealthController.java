package com.dsm.iguana.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api/health")
public class HealthController {

    @GetMapping
    public ResponseEntity<String> simpleHealthCheck() {
        return new ResponseEntity<>("Healthy", HttpStatus.OK);
    }

}
