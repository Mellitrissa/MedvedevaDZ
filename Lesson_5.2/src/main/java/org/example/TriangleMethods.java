package org.example;

public interface TriangleMethods {

    default double perimeterTriangle(double a,double b,double c) {
        return a + b + c;
    }


    default double areaTriangle(double a,double b,double c) {
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}
