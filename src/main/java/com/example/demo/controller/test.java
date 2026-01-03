package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class test {

    @GetMapping
    public Map<String, String> message() {
        return Map.of(
                "from", "Spring Boot",
                "content", "Bonjour depuis le backend 🚀"
        );
    }

}
