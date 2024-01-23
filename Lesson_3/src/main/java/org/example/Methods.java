package org.example;

public class Methods {
    public boolean checkSum(int a, int b) { //метод задания 1
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }

    public void printNumberType(int number) { //метод задания 2
        if (number >= 0) {
            System.out.println("Положительное число");
        } else {
            System.out.println("Отрицательное число");
        }
    }
    public boolean numberType(int number) { //метод задания 3
        return number < 0;
    }

    public void printString(String str, int count) { //метод задания 4
        for (int i = 0; i < count; i++) {
            System.out.println(str);
        }
    }
    public boolean yearType(int year){ //метод задания 5
        if(year%400==0){
            return true;
        }else if (year%100==0){
            return false;
        }
        return year % 4 == 0;
    }
    public int [] createArray(int len, int initialValue){ //метод задания 10
        int[] array = new int[len];
        for (int i = 0; i < len; i ++) {
            array [i] = initialValue;
        }return array;
    }
}
