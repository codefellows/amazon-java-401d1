package demo;

public class ChristmasParty {
    public String name;
    private String theme;
    private Integer attendees;

    public ChristmasParty(String name, String theme, Integer attendees) {
        this.name = name;
        this.theme = theme;
        this.attendees = attendees;
    }

    public void party() {
        System.out.println(this.name + " is an awesome party");
    }

    public String toString() {
        return String.format(
                "Join us at %s, a %s themed party with %d attendees",
                this.name,
                this.theme,
                this.attendees
        );
    }
}
