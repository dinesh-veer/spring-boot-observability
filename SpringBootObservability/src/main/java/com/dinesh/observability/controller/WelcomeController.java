package com.dinesh.observability.controller;

import com.dinesh.observability.entity.User;
import com.dinesh.observability.service.UserService;
import io.micrometer.observation.annotation.Observed;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
public class WelcomeController {

    private final UserService userService;


    @Observed(name = "welcome.logs")
    @GetMapping
    public String welcome() {
        log.warn("sample warn log");
        return "sample warn log";
    }

    @Observed(name = "welcome.error")
    @GetMapping("/log-error")
    public String error() {
        log.error("sample error log");
        return "sample error log";
    }

    @GetMapping("/users")
    public List<User> users() {
        log.info("Getting all users information");
        return userService.getAllUsers();
    }
}
