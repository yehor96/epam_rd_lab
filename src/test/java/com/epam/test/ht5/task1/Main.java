package com.epam.test.ht5.task1;

import com.epam.test.ht8.task3.Serialization;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Chef chef = new Chef();
        Salad salad = chef.cookSalad();
        System.out.println("======== Original classes ========");
        displayInfo(chef, salad);

        String file1 = ".\\additional_files\\SerializedObjectSalad.ser";
        String file2 = ".\\additional_files\\\\SerializedObjectChef.ser";
        Serialization<Salad> serializerSalad = new Serialization<>();
        Serialization<Chef> serializerChef = new Serialization<>();

        serializerSalad.serializeObject(salad, file1);
        serializerChef.serializeObject(chef, file2);

        Salad newSalad = serializerSalad.deserializeObject(file1);
        Chef newChef = serializerChef.deserializeObject(file2);

        System.out.println("======== Deserialized classes ========");
        newChef.setSalad(newSalad);
        displayInfo(newChef, newSalad);
    }

    public static void displayInfo(Chef chef, Salad salad){
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
