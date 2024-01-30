package org.example;

public class Dog extends Animal{
    static int countDog;

    public Dog(String name) {
        super(name);
        countDog++;
    }
    public  static int getCountDog(){
        return countDog;
    }

    @Override
    public void runAnimal(int length) {
        if (length <= 500){
            System.out.println(name + " Пробежал " + length +" метров");
        }else {
            System.out.println("Собаки так делеко не бегают");
        }
    }

    @Override
    public void swimAnimal(int length) {
        if(length<=10){
            System.out.println(name + " Проплыл " + length +" метров");
        } else {
            System.out.println("Собаки так делеко не плавают");
        }
    }
}
