package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Methods methods = new Methods();
        // Задание 1
        System.out.println(methods.checkSum(1, 5));
        // Задание 2
        methods.printNumberType(0);
        // Задание 3
        System.out.println(methods.numberType(-1));
        // Задание 4
        methods.printString("Добрый день", 3);
        // Задание 5
        System.out.println(methods.yearType(2013));
        // Задание 6
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                arr[i] = 0;
            } else {
                arr[i] = 1;
            }
            System.out.println(arr[i]);
        }
        // Задание 7
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
            System.out.println(array[i]);
        }
        // Задание 8
        int[] numbers = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 6){
                numbers[i] *= 2;
            }else {
                numbers[i]*=1;
            }
            System.out.println(numbers[i]);
        }
        // Задание 9
        int [][] twoDimArray = new int [8][8];
        for (int i = 0; i < twoDimArray.length; i++) {
            for (int j = 0; j < twoDimArray[0].length; j++) {
                if ((i + j) % 2 == 0) twoDimArray[i][j] = 1;
                else twoDimArray[i][j] = 0;
            }
        }

        for (int[] ints : twoDimArray) {
            for (int j = 0; j < twoDimArray[0].length; j++) {
                System.out.print(" " + ints[j] + " ");
            }
            System.out.println();
        }
        // Задание 10
        System.out.println(Arrays.toString(methods.createArray(10,5)));
    }
}