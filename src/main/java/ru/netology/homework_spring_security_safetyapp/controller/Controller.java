package ru.netology.homework_spring_security_safetyapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/read")
    public String read() {
        return "READ";
    }

    @GetMapping("/write")
    public String write() {
        return "WRITE";
    }

    @GetMapping("/delete")
    public String delete() {
        return "DELETE";
    }
}
