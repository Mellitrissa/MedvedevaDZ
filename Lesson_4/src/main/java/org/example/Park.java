package org.example;

public class Park {
    String parkName;
    public Park(String parkName){
        this.parkName=parkName;
    }
    public class Attraction{
        String attractionName;
        String workTime;
        double price;
        public Attraction(String attractionName, String workTime, double price){
            this.attractionName=attractionName;
            this.workTime=workTime;
            this.price=price;
        }
        public void infoAttraction(){
            System.out.println("Название парка: " + parkName);
            System.out.println("Название аттракциона: " + attractionName);
            System.out.println("Время работы: " + workTime);
            System.out.println("Цена: " + price);
        }
    }
}
