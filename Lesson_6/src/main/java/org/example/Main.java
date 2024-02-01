package org.example;

import java.io.File;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        File file = new File("data.cvs");
        String[] header = {"Value1", "Value2", "Value3"};
        int[][] data = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        AppData appData = new AppData(header, data);
        CsvService.save(appData, file);
        AppData loadedData = CsvService.load(file);
        System.out.println(Arrays.toString(loadedData.getHeader()));
        for (int[] row : loadedData.getData()) {
            System.out.println(Arrays.toString(row));
        }
    }
}