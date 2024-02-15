package org.example;

public class Main {
    public static void main(String[] args) {
        Box<Apple> appleBox1 = new Box<>();
        appleBox1.addFruit(new Apple());
        appleBox1.addFruit(new Apple());

        Box<Apple> appleBox2 = new Box<>();
        appleBox2.addFruit(new Apple());

        Box<Orange> orangeBox = new Box<>();
        orangeBox.addFruit(new Orange());
        orangeBox.addFruit(new Orange());
        System.out.println("Вес коробки: " + appleBox1.getWeight());
        System.out.println("Вес коробки: " + appleBox2.getWeight());
        System.out.println("Вес коробки: " + orangeBox.getWeight());

        System.out.println("Равен ли вес коробок: " + appleBox1.compare(appleBox2));
        System.out.println("Равен ли вес коробок: " + appleBox1.compare(orangeBox));

        appleBox1.transferFruit(appleBox2);

        System.out.println("Вес первой коробки после переноса фруктов: " + appleBox1.getWeight());
        System.out.println("вес второй коробки после переноса фруктов: " + appleBox2.getWeight());
    }

}