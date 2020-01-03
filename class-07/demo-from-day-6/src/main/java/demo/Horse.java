package demo;

import java.util.ArrayList;

public class Horse implements ShelterableAnimal {
    String[] favoriteFoods = {"carrot", "hay", "grass", "hamburgers"};
    String[] animalsILikeToKick = {"tiger", "dog", "human"};
    String name;

    public Horse( String name, String[] kickingAnimals){
        this.name = name;
        this.animalsILikeToKick = kickingAnimals;

    }

    public Horse (String name){
        this.name = name;
    }

    public String eat(String food){
        for(String likedFood : favoriteFoods){
            if(likedFood.equals(food)){
                return "yum";
            }
        }
        return "ew";
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

    @Override
    public String[] checkEnemies(String[] otherAnimals) {
        ArrayList<String> kickedAnimals = new ArrayList<String>();

        for(String animal : otherAnimals){
            for(String myAnimal : this.animalsILikeToKick){
                if(animal.equals(myAnimal)){
                    kickedAnimals.add(animal);
                }
            }
        }
        String[] result =  kickedAnimals.toArray(new String[1] );
        return result;
    }
}
