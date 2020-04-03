package com.ncarignan.icecream.controllers;

import com.ncarignan.icecream.models.IceCream;
import com.ncarignan.icecream.models.IceCreamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class IceCreamController {

    @Autowired
    IceCreamRepository iceCreamRepository;

    @PostMapping("/icecream")
    public RedirectView makeIceCream(String flavor){
        // make a new ice cream
        // instantiate it
        IceCream newIceCream = new IceCream(flavor);
        iceCreamRepository.save(newIceCream);
        return new RedirectView("/icecream");
    }

    @GetMapping("/icecream")
    public String getAllIceCream(Model m){
        List<IceCream> iceCreams = iceCreamRepository.findAll();
        m.addAttribute("iceCreamArray", iceCreams);
        return "icecream";
    }

}
