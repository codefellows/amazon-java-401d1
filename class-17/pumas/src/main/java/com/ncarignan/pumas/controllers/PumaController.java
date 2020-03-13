package com.ncarignan.pumas.controllers;

import com.ncarignan.pumas.models.ApplicationUser;
import com.ncarignan.pumas.models.ApplicationUserRepository;
import com.ncarignan.pumas.models.Puma;
import com.ncarignan.pumas.models.PumaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;

@Controller
public class PumaController {

    @Autowired
    ApplicationUserRepository applicationUserRepository;

    @Autowired
    PumaRepository pumaRepository;

    @PostMapping("/adoption")
    public RedirectView adoptAPuma(Principal p, String firstName, String lastName, String color, int age, boolean domestic){
//            ApplicationUser owner, String firstName, String lastName, String color, int age, boolean domestic) {

            ApplicationUser owner = applicationUserRepository.findByUsername(p.getName());
            Puma adoptedPuma = new Puma(owner, firstName, lastName, color, age, domestic);
            pumaRepository.save(adoptedPuma);

            return new RedirectView("/users/" + owner.getId());
    }

}
