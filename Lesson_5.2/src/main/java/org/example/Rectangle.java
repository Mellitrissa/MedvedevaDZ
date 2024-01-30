package org.example;

public class Rectangle implements FigureMethods,RectangleMethods{
    String nameFigure;
    double a;
    double b;
    String fillColor;
    String borderColor;
    public Rectangle(double a, double b,String fillColor,String borderColor){
        this.nameFigure="Прямоугольник";
        this.a=a;
        this.b=b;
        this.fillColor=fillColor;
        this.borderColor=borderColor;
        }

    @Override
    public void figureInfo() {
        System.out.println("Название фигуры :" + nameFigure);
        System.out.println("Площадь: " + areaRectangle(a,b));
        System.out.println("Периметр: " + perimeterRectangle(a,b));
        System.out.println("Цвет фона: " + fillColor);
        System.out.println("Цвет границ: " + borderColor);
    }
}
