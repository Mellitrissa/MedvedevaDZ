package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CsvService {
    public static void save(AppData data, File file) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            StringBuilder headerLine = new StringBuilder();
            for (String headerValue : data.getHeader()) {
                headerLine.append(headerValue).append(";");
            }
            writer.write(headerLine.toString());
            writer.newLine();
            for (int[] row : data.getData()) {
                StringBuilder dataLine = new StringBuilder();
                for (int value : row) {
                    dataLine.append(value).append(";");
                }
                writer.write(dataLine.toString());
                writer.newLine();
            }
        }  catch (IOException e) {
            System.out.println("Ошибка сохранения файла");
            e.printStackTrace();
        }
    }
    public static AppData load (File file){
        AppData appData = new AppData();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            String headerLine = reader.readLine();
            String [] headerValues = headerLine.split(";");
            appData.setHeader(headerValues);
            List<int[]> dataList = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(";");
                int[] data = new int[values.length];
                for (int i = 0; i < values.length; i++) {
                    data[i] = Integer.parseInt(values[i]);
                }
                dataList.add(data);
            }
            int[][] data = new int[dataList.size()][];
            for (int i = 0; i < dataList.size(); i++) {
                data[i] = dataList.get(i);
            }
            appData.setData(data);

        }catch (IOException e){
            System.out.println("Ошибка сохранения файла");
            e.printStackTrace();
        }
        return appData;
    }

}
