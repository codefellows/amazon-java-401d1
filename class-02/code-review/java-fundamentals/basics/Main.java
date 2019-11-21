import java.util.Random;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args){
        int dogCount = 1;
        System.out.println("I own " + dogCount + " " + pluralize("dog", dogCount) + ".");

        int catCount = 2;
        System.out.println("I own " + catCount + " " + pluralize("cat", catCount) + ".");

        int turtleCount = 0;
        System.out.println("I own " + turtleCount + " " + pluralize("turtle", turtleCount) + ".");

        flipNHeads(13);

        clock();
    }

    public static String pluralize(String word, int num){
        if (num > 1 || num == 0){
            word = word + "s";
        }
        return word;
    }

    public static void flipNHeads(int n){
        Random generator = new Random();
        Math.random()
        Double randomNumber = generator.nextDouble();
        int flipCount = 0;
        int headCount = 0;

        while (headCount < n) {
            flipCount++;
            if (randomNumber > 0.5) {
                System.out.println("heads");
                headCount++;
            } else {
                System.out.println("tails");
                headCount = 0;
            }
            randomNumber = generator.nextDouble();
        }
        System.out.println("It took " + flipCount + " " + pluralize("flip", flipCount) + " to flip " + headCount + " " +  pluralize("head", headCount) + " in a row.");   
    }

    public static void clock(){   
        String previousTime = "start";
        int clockSpeed = 0;
        
        while (true) {
        clockSpeed++;
        LocalDateTime currentTime = LocalDateTime.now();
        String formattedTime = currentTime.format( DateTimeFormatter.ofPattern("HH:mm:ss") );
        
        if (!formattedTime.equals(previousTime)){
            String clockSpeedUnit = " Hz";
            float clockSpeedFloat = (float)clockSpeed;
        
            if (clockSpeed > 1000 && clockSpeed < 1_000_001) {
                clockSpeedFloat = (float)clockSpeed / 1000;
                clockSpeedUnit = " MHz";
            } else if (clockSpeed > 1_000_000) {
                clockSpeedFloat = (float)clockSpeed / 1_000_000;
                clockSpeedUnit = " GHz";
            }
            System.out.println(formattedTime + " " + clockSpeedFloat + clockSpeedUnit);
            clockSpeed = 0;    
        }
            previousTime = formattedTime;
        }        
    }
}