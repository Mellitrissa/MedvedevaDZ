package org.example;

public class Method {
    public static int arrayConversion  (String [][] arr) throws MyArraySizeException, MyArrayDataException{
        if(arr.length != 4) {throw new MyArraySizeException("Неверный размер массива");}
        int sum=0;
        for(int i = 0; i < arr.length; i++) {
            if (arr[i].length != 4) {
                throw new MyArraySizeException("Неверный размер массива");
            }
            for(int k = 0; k < arr.length; k++){
                try {
                    sum += Integer.parseInt(arr[i][k]);
                }catch (NumberFormatException ex){
                    throw  new MyArrayDataException("Ошибка в ячейке: " + i + "x" + k);
                }
            }
        }
        return sum;
    }
}
