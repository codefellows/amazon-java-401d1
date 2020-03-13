package com.ncarignan.pumas.models;

import javax.persistence.*;

@Entity
public class Puma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    String firstName;
    String lastName;
    String color;
    int age;
    boolean domestic;

    @ManyToOne
    ApplicationUser owner;

    // pumas need to be adopted
    public Puma(){}

    public Puma(ApplicationUser owner, String firstName, String lastName, String color, int age, boolean domestic) {
        this.owner = owner;
        this.firstName = firstName;
        this.lastName = lastName;
        this.color = color;
        this.age = age;
        this.domestic = domestic;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isDomestic() {
        return domestic;
    }

    public void setDomestic(boolean domestic) {
        this.domestic = domestic;
    }


}
