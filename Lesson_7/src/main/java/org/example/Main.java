package org.example;

public class Main {
    public static void main(String[] args) {
        String[][] arr = new String[][]{{"1", "2", "3", "4"}, {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},{"13", "14", "15", "16"}};


            try {
               System.out.println("Сумма = " + Method.arrayConversion(arr));
            }catch (MyArraySizeException | MyArrayDataException e){
                System.out.println(e.getMessage());

            }

    }
}