package com.main.sbl_spring_lv1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SwaggerController {
    @GetMapping("/api/hello")
    public String hello(){
        return "Hllo World";
    }
}
