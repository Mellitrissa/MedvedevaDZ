package org.example;

public  class Animal {
    String name;
      static int count;
     public Animal(String name){
         this.name =name;
         count++;
     }
     public  static int getCount(){
         return count;
     }
     public String getName(){
         return name;
     }


    public  void runAnimal(int length){
        System.out.println(name + " Пробежал " + length +" метров");

    }
    public  void swimAnimal(int length){
        System.out.println(name + " Проплыл " + length +" метров");

    }
}
