package com.pluralsight.conferencedemo.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(EndPoints.Health)
public class HealthController {

    @Value("${app.version}")
    private String version;

    @GetMapping
    public ResponseEntity<Map> getHealthStatus() {
        Map statusMap = new HashMap<String, String>();
        statusMap.put("status", "up");
        statusMap.put("version", version);

        return new ResponseEntity<>(statusMap, HttpStatus.OK);
    }
}
