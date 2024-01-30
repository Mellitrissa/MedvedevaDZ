package org.example;

public class Triangle implements FigureMethods,TriangleMethods{
    String nameFigure;
    double a;
    double b;
    double c;
    String fillColor;
    String borderColor;
    public Triangle(double a,double b,double c,String fillColor,String borderColor){
        this.nameFigure="Треугольник";
        this.a=a;
        this.b=b;
        this.c=c;
        this.fillColor=fillColor;
        this.borderColor=borderColor;
    }

    @Override
    public void figureInfo() {
        System.out.println("Название фигуры :" + nameFigure);
        System.out.println("Площадь: " + areaTriangle(a,b,c));
        System.out.println("Периметр: " + perimeterTriangle(a,b,c));
        System.out.println("Цвет фона: " + fillColor);
        System.out.println("Цвет границ: " + borderColor);

    }
}
