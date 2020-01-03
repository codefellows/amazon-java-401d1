package demo;

public interface ShelterableAnimal {
    // Define methods required by this interface, you need
    // return type, and name, and inputs
    public String eat(String food);
    public String play();
    public String play(String toys);
    public int getHealth();
    public String[] checkEnemies(String[] otherAnimals);
}
