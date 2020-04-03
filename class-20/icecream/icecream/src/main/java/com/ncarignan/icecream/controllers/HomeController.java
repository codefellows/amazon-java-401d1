package com.ncarignan.icecream.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class HomeController {
//    getmapping sets up a get route, it returns a string to let thymeleaf know
//    the name of the html file in templates it should render
    @GetMapping("/")
    public String home(Principal p, Model m){
        if(p != null){
            System.out.println("user is logged in");
            m.addAttribute("username", p.getName());
        }
        return "index";
    }
}
