package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        String [] arr = {"Москва","Волгоград","Рязань","Москва","Астрахань","Можайск","Самара","Самара",
                "Краснодар","Сочи","Омск","Сочи","Сочи","Екатериненбург","Выборг","Кисловодск","Москва","Адлер","Уфа"};
        HashMap<String, Integer> wordToCount = new HashMap<>();
        for (String word : arr){
            wordToCount.put(word, wordToCount.getOrDefault(word, 0) + 1);
            }
        System.out.println("Количество повторений:");
            for (String word : wordToCount.keySet())
        {
            System.out.println(word + " " + wordToCount.get(word));
        }

        Set<String> uniqueWords = new HashSet<>(Arrays.asList(arr));
        System.out.println("Уникальные слова:");
        for (String word : uniqueWords) {
            System.out.print(word + " ");
        }
        System.out.println();
        Phonebook phonebook = new Phonebook();
        phonebook.add("Петров","89270899326");
        phonebook.add("Иванова","89023514698");
        phonebook.add("Сидоров","89173045785");
        phonebook.add("Петров","8800234512");
        phonebook.add("Петров","8904567890");
        phonebook.add("Сидоров","88512345678");
        phonebook.add("Васильева","8809179034");
        System.out.println("Номер телефона: " + phonebook.get("Петров"));
        System.out.println("Номер телефона: " + phonebook.get("Васильева"));

    }
}