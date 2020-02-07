package com.ncarignan.songr;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Emotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    public String feeling;
    String personWhoHasIt;
    String why;
    public Date whenIFeltIt; // dont make it when

    public Emotion(String feeling, String personWhoHasIt, String why) {
        this.feeling = feeling;
        this.personWhoHasIt = personWhoHasIt;
        this.why = why;
    }

    public Emotion(String feeling, String personWhoHasIt, String why, Date date) {
        this.feeling = feeling;
        this.personWhoHasIt = personWhoHasIt;
        this.why = why;
        this.whenIFeltIt = date;
    }

    // required by jpa - reason being it its not intelligent enough to use that one ^
// fresh template to put things from the db back to java
    public Emotion(){
    }


    public String getPersonWhoHasIt() {
        return personWhoHasIt;
    }

    public String getWhy() {
        return why;
    }
}
