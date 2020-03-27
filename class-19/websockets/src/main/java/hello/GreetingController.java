package hello;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class GreetingController {

    // If a client sends a message ("Nicholas") to 8080/hello
    @MessageMapping("/hello")
    // it will send the return value (a Greeting) to everyone subscribed to /topic/greetings
    @SendTo("/topic/greetings") // the client has subscribed to greetings, all clients will receive the message
    public Greeting greeting(HelloMessage message) throws Exception {
        System.out.println("message happenin");
        Thread.sleep(1000); // simulated delay
        return new Greeting("Hello, " + message.getName() + "!");
    }

    // if any client messages /app/goodbye - everyone will see "seeYaLAter
    @MessageMapping("/goodbye")
    @SendTo("/topic/greetings")
    public Goodbye goodbye(GoodByeMessage message) {

        Goodbye seeYa = new Goodbye();
        seeYa.goodbyeMessage = "see ya later";
        return seeYa;
    }

}
