package org.example;

public class Methods {

    public void printThreeWords(){
        System.out.println("Orange\nBanana\nApple ");

    }

    public void checkSumSign(){
        int a = 1;
        int b = 5;
        int sum;
        sum = a+b;
        if (sum >= 0){
            System.out.println( "Сумма положительная");
        } else {System.out.println( "Сумма отрицательная");}
    }
    public void printColor(){
        int value = 105;
        if(value <= 0){
            System.out.println("Красный");
        } else if((value > 0) && (value <=100) ){
            System.out.println("Желтый");
        } else if (value > 100){
            System.out.println("Зеленый");
        }
    }
    public void compareNumbers(){
        int a = 2;
        int b = 4;
        if(a >= b){
            System.out.println("a >= b");
        } else System.out.println("a < b");
    }





}
