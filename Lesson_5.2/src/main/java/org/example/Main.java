package org.example;

public class Main {
    public static void main(String[] args) {
        Circle circle1 = new Circle(5,"Красный","Черный");
        circle1.figureInfo();
        Rectangle rectangle1 = new Rectangle(3,5,"Белый","Красный");
        rectangle1.figureInfo();
        Triangle triangle1 = new Triangle(5,4,4,"Зеленый","Черный");
        triangle1.figureInfo();

    }
}