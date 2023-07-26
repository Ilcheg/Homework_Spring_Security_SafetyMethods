package ru.netology.homework_spring_security_safetyapp.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
public class Controller {

    @GetMapping("/read")
    @Secured({"ROLE_read"})
    public String read() {
        return "READ";
    }

    @GetMapping("/write")
    @RolesAllowed({"ROLE_write"})
    public String write() {
        return "WRITE";
    }

    @GetMapping("/delete")
    @PreAuthorize("hasAnyRole('delete', 'write')")
    public String delete() {
        return "DELETE";
    }

    @GetMapping("/username")
    @PreAuthorize("#userName == authentication.principal.username")
    public String checkUserName(@RequestParam("username") String userName) {
        return "Your Username is allowed to use this method!";
    }
}
