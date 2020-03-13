package com.ncarignan.pumas.controllers;

import com.ncarignan.pumas.models.ApplicationUser;
import com.ncarignan.pumas.models.ApplicationUserRepository;
import com.ncarignan.pumas.models.Puma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.util.List;

@Controller
public class ApplicationUserController {

    @Autowired
    ApplicationUserRepository applicationUserRepository;

    @Autowired private PasswordEncoder passwordEncoder;

    @PostMapping("/signup")
    public RedirectView createNewApplicationUser(String username, String password){
        System.out.println("You are adding a user");
        // make the user AND salt and hash the password
        // this does the salting and hashing for you
        ApplicationUser newUser = new ApplicationUser(username, passwordEncoder.encode(password));

        // save the user to db
        applicationUserRepository.save(newUser);

        // send them back home
        return new RedirectView("/");
    }

    @GetMapping("/login")
    public String showLoginForm(){
        return "login";
    }

    @GetMapping("/users/{idPotato}")
    public String getUserProfile(Model m, @PathVariable long idPotato, Principal p){
        ApplicationUser user = applicationUserRepository.getOne(idPotato);
        m.addAttribute("usernameWeAreVisiting", user.getUsername());
        m.addAttribute("loggedInUserName", p.getName());
        List<Puma> pumas = user.pumaPets;
        System.out.println(pumas + "suuuup");
        System.out.println(pumas.get(0).getFirstName());
        m.addAttribute("pumas", user.pumaPets);
        return "userDetails";
    }

}
