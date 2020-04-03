package com.ncarignan.icecream.controllers;

import com.ncarignan.icecream.models.ApplicationUser;
import com.ncarignan.icecream.models.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class ApplicationUserController {
    @Autowired
    ApplicationUserRepository applicationUserRepository;

    @Autowired
    @Qualifier("authenticationManager")
    AuthenticationManager authenticationManager;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/users")
    public RedirectView createUser(String username, String password, HttpServletRequest request, HttpSession session){
        System.out.println("users being made");
        ApplicationUser newUser = new ApplicationUser(username, passwordEncoder.encode(password));
        applicationUserRepository.save(newUser);
        System.out.println("saved");

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, passwordEncoder.encode(password));
        System.out.println("made token");
        request.getSession();
        System.out.println("got session");
        token.setDetails(new WebAuthenticationDetails(request));
        System.out.println("set details");
        Authentication authenticatedUser = authenticationManager.authenticate(token);
        System.out.println("im a weird authenticator");
        System.out.println("token name : " + token.getName());
        SecurityContextHolder.getContext().setAuthentication(authenticatedUser);
        request.getSession().setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, SecurityContextHolder.getContext());

        session.setAttribute("username", username);
        session.setAttribute("authorities", token.getAuthorities());

        return new RedirectView("/");

    }
}
