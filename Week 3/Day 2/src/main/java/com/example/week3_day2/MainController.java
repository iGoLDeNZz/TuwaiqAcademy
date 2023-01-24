package com.example.week3_day2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {


    @GetMapping("/name")
    public String getName() {
        return "My name is Yousef. Nice to meet you.";
    }

    @GetMapping("/age")
    public String getAge() {
        return "I rather not telling you.";
    }

    @GetMapping("/check/status")
    public String getStatus() {
        return "Everything is running smoothly";
    }


    @GetMapping("/health")
    public String getHealth() {
        return "Server health is up and running";
    }
}
