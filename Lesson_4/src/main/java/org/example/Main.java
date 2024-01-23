package org.example;

public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee("Иванов Иван Иванович","Экономист","ivan@gmail.ru",
                "+79023457892",70000,27);
        employee.printInfo();
        Employee [] employees = new Employee[5];
        employees[0]= new Employee("Петров Василий Александрович","Начальник отдела",
                "petr@mail.ru","+79087945678",120000,36);
        employees[1] = new Employee("Васильева Екатерина Михайловна","Главный бухгалтер",
                "katya@yandex.ru","+79170977326",105000.7,50);
        employees[2] = new Employee("Андреев Валентин Алексеевич","Системный администратор",
                "vasio@mail.ru","+79275588427",85000,25);
        employees[3] = new Employee("Пушкин Александр Сергеевич","Маркетолог",
                "pushka@gmail.ru","+79085678903",85000,32);
        employees[4] = new Employee("Меньшикова Юлия Андреевна","Экономист",
                "julia@yandex.com","+79032345678",73500.6,24);
        employees[3].printInfo();
        Park.Attraction attraction = new Park("Ромашка").new Attraction("Колесо обозрения",
                "с 9:00 до 21:00",200);
        attraction.infoAttraction();
    }
}