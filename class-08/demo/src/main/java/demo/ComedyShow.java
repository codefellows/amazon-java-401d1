package demo;

public class ComedyShow {

    private final String name;
    private final String theme;
    private final Integer attendees;

    ComedyShow (String name, String theme, Integer attendees){

        this.name = name;
        this.theme = theme;
        this.attendees = attendees;
    }

    @Override
    public String toString() {
        return "So funny " + this.name;
    }
}
