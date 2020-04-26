package com.example.e_med_help.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/physician")
@Controller
public class PhysicianController {

    @GetMapping("/home")
    public String goHome() {
        return "physician";
    }
}
