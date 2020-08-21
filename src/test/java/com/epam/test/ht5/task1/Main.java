package com.epam.test.ht5.task1;

public class Main {

    public static void main(String[] args) {

        Chef chef = new Chef();
        Salad salad = chef.cookSalad();

        System.out.println("Salad contains " + chef.getCalories(salad) + " calories.");

        System.out.println("All ingredients in alphabetical order:");
        chef.getIngredientsOrderedByName(salad);

        System.out.println("Get ingredients with calories: ");
        chef.getIngredientsWithCalories(salad);

        int theSmallestAmountOfCalories = 30;
        int theLargestAmountOfCalories = 50;
        System.out.println("Get ingredients from " +
                theSmallestAmountOfCalories + " to "
                + theLargestAmountOfCalories + ":");
        chef.getIngredientsWithCalories(salad, theSmallestAmountOfCalories, theLargestAmountOfCalories);
    }
}
