package demo;

public class Dog {

    private final String name;
    private final String breed;

    public Dog (String name, String breed){

        this.name = name;
        this.breed = breed;
    }

    @Override
    public String toString() {
        return "I am a " + this.breed + " named " + this.name;
    }
}
