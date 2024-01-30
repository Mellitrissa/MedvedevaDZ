package org.example;

public class Cat extends Animal{
    static int countCat;
    boolean satiety;

    public Cat(String name) {
        super(name);
        countCat++;
        satiety = false;
    }
    public  static int getCountCat(){
        return countCat;
    }
    @Override
    public void runAnimal(int length){
        if(length<= 200){
            System.out.println(name + " Пробежал " + length +" метров");
        } else {
            System.out.println("Кошки так делеко не бегают");
        }

    }
    @Override
    public void swimAnimal(int length){
        System.out.println("Кошки не умеет плавать");
    }
    public void eatFromBowl(int foodAmount){
            if (foodAmount <= 0) {
                System.out.println("Кот не может съесть отрицательное количество еды.");
            } else if (satiety) {
                    System.out.println("Кот уже сыт.");
            } else {
                satiety = true;
                System.out.println("Кот покушал и теперь сыт.");
            }
    }

}
