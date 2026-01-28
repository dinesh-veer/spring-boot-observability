package com.dinesh.springboot4observability.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@Slf4j
public class WelcomeController {
   // private Logger log = Logger.getLogger(WelcomeController.class.getName());

    @GetMapping
    public String welcome() {
        log.info("Welcome endpoint called");
      return "Welcome endpoint called";
    }

    @GetMapping("/greet/{name}")
    public String greetMessage(@PathVariable String name) {
        log.info("Greeting user: {}", name);
        simulateWork();
        return "Hello, " + name + "!";
    }

    @GetMapping("/slow")
    public String slowApi() throws InterruptedException {
        log.info("Starting DB operation");
        Thread.sleep(500);
        log.info("DB operation completed");
        return "Completed!";
    }

    private void simulateWork() {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
