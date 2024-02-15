package org.example;

import java.util.ArrayList;

public class Box <T extends Fruit> {

    private final ArrayList<T> fruits;

    public Box() {
        fruits = new ArrayList<>();
    }


    public double getWeight() {
        double weight=0;
        for (T fruit : fruits) {
            weight += fruit.weightOne;
        }
        return weight;
    }
    public boolean compare(Box <?> anotherBox){
        return this.getWeight() == anotherBox.getWeight();
    }
    public void addFruit(T fruit){
        fruits.add(fruit);
    }
    public void transferFruit(Box <T> anotherBox){
        if(this.getClass() != anotherBox.getClass()){
            System.out.println("В коробках лежат разные фрукты");
        }else anotherBox.fruits.addAll(fruits);
        this.fruits.clear();
    }
}
