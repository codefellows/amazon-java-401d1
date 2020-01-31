package com.ncarignan.songr;

public class Emotion {
    public String feeling;
    String personWhoHasIt;
    String why;

    public Emotion(String feeling, String personWhoHasIt, String why) {
        this.feeling = feeling;
        this.personWhoHasIt = personWhoHasIt;
        this.why = why;
    }

    public String getPersonWhoHasIt() {
        return personWhoHasIt;
    }

    public String getWhy() {
        return why;
    }
}
