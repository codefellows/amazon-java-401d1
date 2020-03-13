package com.ncarignan.pumas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class HomeController {

    // what I want is to show the username on the main page
    // Principal means logged in user
    // still need model m to send the data to the html, to thymeleaf
    @GetMapping("/")
    public String getHome(Principal p, Model m){
        // Principal: principal is the object that spring uses to pass the logged in user around

        if(p != null){
            m.addAttribute("username", p.getName());
        }

        return "home";
    }
}
