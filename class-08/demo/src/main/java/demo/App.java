/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package demo;

import com.google.gson.Gson;

import java.io.*;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws IOException {
        ChristmasParty attackOfTheSweaters = new ChristmasParty("attack of the sweaters", "Star Wars Sweater", 9);
        System.out.println(attackOfTheSweaters);
        attackOfTheSweaters.party();

        Gson gson = new Gson();
        String stringyAttackOfTheSweaters = gson.toJson(attackOfTheSweaters);
        System.out.println("stringyAttackOfTheSweaters = " + stringyAttackOfTheSweaters);
        // TODO: add a next party feature

//        stringyAttackOfTheSweaters.party();

        ChristmasParty sweaterParty = gson.fromJson(stringyAttackOfTheSweaters, ChristmasParty.class);
        sweaterParty.name = "unlimeted sweat-ers";
        sweaterParty.party();
//
        Scanner reader = new Scanner(new File("src/main/resources/christmasParties.json"));
        String firstLine = reader.nextLine();
        System.out.println("firstLine = " + firstLine);
        ChristmasParty punny = gson.fromJson(firstLine, ChristmasParty.class);
        System.out.println("punny = " + punny);

        File newFile = new File("src/main/resources/test4.json");
        FileWriter writer = new FileWriter("src/main/resources/test4.json");
        gson.toJson(sweaterParty, writer);
        writer.close();

        System.out.println("my frist line was " + firstLine);

        FourthParty thomsParty = gson.fromJson(firstLine, FourthParty.class);
        System.out.println(thomsParty);


////        File f = new File("src/main/resources/myParty.json");
////        FileWriter coolWriter = new FileWriter("src/main/resources/myParty.json");
////        gson.toJson(attackOfTheSweaters, coolWriter);
////        coolWriter.close();
//        Scanner reader = new Scanner(new File("src/main/resources/myParty.json"));
//        String firstLine = reader.nextLine();
//        System.out.println("from a file" + firstLine);
//        System.out.println(gson.fromJson(firstLine, ChristmasParty.class));
//
//        ChristmasParty fromFileParty = gson.fromJson(firstLine, ChristmasParty.class);
//        fromFileParty.party();
//
//        System.out.println(gson.fromJson(firstLine, ComedyShow.class));
//        System.out.println(gson.fromJson(firstLine, Dog.class));
//        System.out.println(gson.fromJson(firstLine, Cat.class));
    }

}
