package demo;

import java.util.ArrayList;

public class Cat implements ShelterableAnimal {
    public String[] hatedAnims = {"cat", "dog", "tiger"};

    public Cat(){

    }

    @Override
    public String eat(String food) {
        return null;
    }

    @Override
    public String play() {
        return null;
    }

    @Override
    public String play(String toys) {
        return null;
    }

    @Override
    public int getHealth() {
        return 0;
    }

    public String[] checkEnemies(String[] otherAnimals) {
        ArrayList<String> kickedAnimals = new ArrayList<String>();

        for(String animal : otherAnimals){
            for(String myAnimal : this.hatedAnims){
                if(animal.equals(myAnimal)){
                    kickedAnimals.add(animal);
                }
            }
        }
        String[] result =  kickedAnimals.toArray(new String[1] );
        return result;
    }
}
