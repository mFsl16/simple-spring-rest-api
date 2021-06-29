package com.faisal.restapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/welcome")
public class Welcome {

    @GetMapping
    public String welcome() {
        return "Welcome to my Rest Api";
    }
}