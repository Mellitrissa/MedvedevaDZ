package org.example;

public class Bowl {
    int foodAmount;

    public Bowl(int foodAmount) {
        this.foodAmount = foodAmount;
    }

    public void addFood(int amount) {
        if (amount <= 0) {
            System.out.println("Нельзя добавить отрицательное количество еды.");
        }else{
            foodAmount += amount;
            System.out.println("В миску добавили " + amount + " еды.");
            }
        }

        public boolean decreaseFood ( int amount){
            if (amount <= 0) {
                System.out.println("Нельзя съесть отрицательное количество еды.");
            return false;
            } else if (foodAmount < amount) {
                System.out.println("В миске недостаточно еды.");
                return false;
            }else{
                foodAmount -= amount;
                return true;
                    }
                }
    public int getFoodAmount () {
        return foodAmount;
    }

}


