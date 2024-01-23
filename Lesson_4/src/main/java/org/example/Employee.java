package org.example;

public class Employee {
    String fullName;
    String position;
    String email;
    String telephoneNumber;
    double salary;
    int age;
    public Employee(String fullName,String position,String email,
                    String telephoneNumber, double salary,int age){
        this.fullName=fullName;
        this.position=position;
        this.email=email;
        this.telephoneNumber=telephoneNumber;
        this.salary=salary;
        this.age=age;
    }
    public void printInfo() {
        System.out.println("Full Name: " + fullName);
        System.out.println("Position: " + position);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + telephoneNumber);
        System.out.println("Salary: " + salary);
        System.out.println("Age: " + age);
    }
}


