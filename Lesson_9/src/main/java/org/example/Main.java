package org.example;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Main {
    public static void main(String[] args) {
        //Задание 1
        Random random = new Random();
        long count = IntStream.of(random.nextInt(20)).filter(w -> w % 2 == 0).count();
        System.out.println(count);
        //Задание 2
        ArrayList<String> words = new ArrayList<>();
        Collections.addAll(words, "Highload", "High", "Load", "Highload");
        long countHigh = words.stream().filter(s -> s.equals("High")).count();
        System.out.println("Количество раз, когда объект \"High\" встречается в коллекции: " + countHigh);
        String firstElement = words.stream().findFirst().orElse("0");
        System.out.println("Элемент на первом месте: " + firstElement);
        String lastElement = words.stream().reduce((a, d) -> d).orElse("0");
        System.out.println("Элемент на последнем месте: " + lastElement);
        //Задание 3
        ArrayList<String> collection = new ArrayList<>();
        Collections.addAll(collection, "f10", "f15", "f2", "f4", "f4");
        collection.sort((s1, s2) -> {
            int num1 = Integer.parseInt(s1.substring(1));
            int num2 = Integer.parseInt(s2.substring(1));
            return Integer.compare(num1, num2);
        });
        String[] sortedArray = collection.toArray(new String[0]);
        System.out.println("Отсортированные элементы:");
        for (String element : sortedArray) {
            System.out.println(element);
        }
        //Задание 4
        Collection<Student> students = Arrays.asList(
                new Student("Дмитрий", 17, Gender.MAN),
                new Student("Максим", 20, Gender.MAN),
                new Student("Екатерина", 20, Gender.WOMEN),
                new Student("Михаил", 28, Gender.MAN)
        );
        double averageAgeMan = students.stream()
                .filter(s -> s.getGender() == Gender.MAN)
                .mapToInt(Student::getAge)
                .average()
                .orElse(0);
        System.out.println("Средний возраст студентов мужского пола: " + averageAgeMan);
        students.stream()
                .filter(student -> student.getAge() >= 18 && student.getAge() <= 27 && student.getGender() == Gender.MAN)
                .forEach(student -> System.out.println("Потенциальные призывкики: " + student.getName()));


    //Задание 5
    Scanner scanner = new Scanner(System.in);
    List<String> logins = new ArrayList<>();
    System.out.println("Введите логины (для завершения введите пустую строку):");
        while(true) {
        String login = scanner.nextLine();
        if (login.isEmpty()) {
            break;
        }
        logins.add(login);
    }
        String result =  logins.stream().filter(login -> login.length() > 0 && login.charAt(0) == 'f' && Character.isLowerCase(login.charAt(0)))
                .collect(Collectors.joining(", "));

        System.out.println("Логины, начинающиеся на букву 'f' в нижнем регистре: " + result);
    }

}
