package org.example;

public class Main {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Барсик");
        Cat cat2 = new Cat("Буся");
        Dog dog1 = new Dog("Бобик");
        Dog dog2 = new Dog("Шарик");
        System.out.println("Создано животных " + Animal.getCount());
        System.out.println("Создано кошек " + Cat.getCountCat());
        System.out.println("Создано cобак " + Dog.getCountDog());
        cat1.runAnimal(150);
        cat2.runAnimal(210);
        cat1.swimAnimal(6);
        dog1.runAnimal(400);
        dog2.runAnimal(600);
        dog1.swimAnimal(9);

        Bowl bowl = new Bowl(20);
        Cat[] cats = new Cat[3];
        cats[0] = new Cat("Пушок");
        cats[1] = new Cat("Лапочка");
        cats[2] = new Cat("Тоша");

        for (Cat c : cats) {
            if (bowl.decreaseFood(5)) {
                c.eatFromBowl(5);
            } else {
                    System.out.println("Еды в миске не хватило для кота.");
                }
            }

            System.out.println("Состояние сытости котов:");
            for (Cat c : cats) {
                System.out.println(c.getName() + ": " + c.satiety);
            }

            bowl.addFood(10);
        }
    }
