package org.example;

public class Circle implements CircleMethods, FigureMethods{
    String nameFigure;
    double radius;
    double area;
    double perimeter;
    String fillColor;
    String borderColor;
    public Circle(double radius,String fillColor,String borderColor){
        this.nameFigure="Круг";
        this.fillColor =fillColor;
        this.borderColor = borderColor;
        this.radius=radius;
        perimeter=perimeterCircle(radius);
        area=areaCircle(radius);
    }


    @Override
    public void figureInfo() {
        System.out.println("Название фигуры :" + nameFigure);
        System.out.println("Площадь: " + area);
        System.out.println("Периметр: " + perimeter);
        System.out.println("Цвет фона: " + fillColor);
        System.out.println("Цвет границ: " + borderColor);

    }
}
