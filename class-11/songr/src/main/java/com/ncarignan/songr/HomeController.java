package com.ncarignan.songr;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;

@Controller // tells spring to look in this class for routes
public class HomeController {

    // this annotation tells spring set up a route at /,
    // use this method to control the behavior
    // this is the same thing as in js app.get("/". showHome)
    @GetMapping("/")
    public String showHome(){
        // Our mappings as of today return strings
        // These strings reference the name of an html file in the "templates" folder
        return "home"; // matches to home.html
    }

    // purpose of saying hello to whoever is here
    // the controller must have a param of Model to do thymeleaf templating
    // http://localhost:8080/hello?user=ginger&hello=goodbye%20person
    @GetMapping("/hello")
    public String sayHello(Model mPotato, String user, String hello){
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
            return "greeting";
    }

    @GetMapping("/emotions")
    public String showEmotions(Model m){
        Emotion[] emotions = {
                new Emotion("hungry", "Sreeni", "its time"),
                new Emotion("happy", "Suda", "learning new things"),
                new Emotion("tired", "Nicholas", "its winter")
        };
        m.addAttribute("emotionsArr", emotions);

        return "emotion";
    }
}









