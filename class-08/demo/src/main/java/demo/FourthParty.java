package demo;

public class FourthParty {
    String name;
    String theme;
    int attendees;

    public String toString(){
        return String.format("come to my fourth of july party called %s, it is themed : %s, there should be %d people", this.name, this.theme, this.attendees);
    }
}
