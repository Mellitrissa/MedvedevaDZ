package org.example;

public interface RectangleMethods {

    default double perimeterRectangle(double a,double b) {
        return 2 * (a + b);
    }

    default double areaRectangle(double a,double b) {
        return a * b;
    }
}
