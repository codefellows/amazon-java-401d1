package com.ncarignan.songr;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.servlet.view.RedirectView;

import java.sql.Date;
import java.util.List;

@Controller // tells spring to look in this class for routes
public class HomeController {

    @Autowired
    public EmotionRepository emotionRepository;


    @GetMapping("/")
    public String showHome(){
        // Our mappings as of today return strings
        // These strings reference the name of an html file in the "templates" folder

        // response.sendFile("home.html");
        // response.redner("home.ejs")
        return "home"; // matches to home.html
    }

    // purpose of saying hello to whoever is here
    // the controller must have a param of Model to do thymeleaf templating
    // http://localhost:8080/hello?user=ginger&hello=goodbye%20person
    @GetMapping("/hello")
    // by default all parameters in a getMapping are treated as query strings
    public String sayHello(Model mPotato, String user, String hello){
        // res.render("greeting.ejs", mPotato)




        // adding String user pulls ?user=nicholas out of the url

        // userGreeting
        // if you add an attribute to the model it will be available in the thymeleaf file
        // this is a key value pair, like a js object, like a hashmap
        // this is like localstorage
        if(user == null){
                user = "guest";
            }

        mPotato.addAttribute("userGreeting", hello + user);
        mPotato.addAttribute("greeting", hello);
        mPotato.addAttribute("h1Color", "skyblue");
            return "greeting";
    }

    @GetMapping("/emotions")
    public String showEmotions(Model m){
        List<Emotion> emotions = emotionRepository.findAll();
        m.addAttribute("emotionsArr", emotions);

        return "emotion";
    }

    @PostMapping("/emotionsAddPotato")
    public RedirectView addEmotion(Date whenIFeltIt, String feeling, String person, String why){
        Emotion newEmotion = new Emotion(feeling, person, why, whenIFeltIt);
        emotionRepository.save(newEmotion);
//        save the emotion
//        we save using the Repository class we created

        return new RedirectView("/emotions");
    }
//    akin to response.redirect('')
//    this will allow us to send them to the emotion display page


    // by default all parameters in a post are treated as properties that should be found in the body
    // form data, raw json
    // we can specify that they are other types on any route
}









