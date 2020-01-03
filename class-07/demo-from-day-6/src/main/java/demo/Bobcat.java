package demo;

// all bobcats are cats
// so the bobcat class is a subtype of the cat class
public class Bobcat extends Cat {
    boolean hasMurdered;
    public Bobcat() {
        // call the constructor of the superclass (aka parent class aka the one we extend)
        super(true, 30, -1);
        this.hasMurdered = false;
    }

    public void kill() {
        System.out.println("WHOOSH SLICE X_X");
        this.hasMurdered = true;
    }

    public boolean hasMurdered() {
        return this.hasMurdered;
    }
}
