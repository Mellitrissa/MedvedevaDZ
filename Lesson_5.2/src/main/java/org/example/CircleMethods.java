package org.example;

public interface CircleMethods {

    default double perimeterCircle(double radius) {
        return 2 * Math.PI * radius;
    }
    default double areaCircle(double radius) {
        return Math.PI * radius * radius;
    }
}
