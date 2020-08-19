package com.epam.test.ht5.task1;

public class Garlic extends OnionCulture {
    public Garlic() {
        Name = "Garlic";
    }

    @Override
    public int getCalories() {
        return 4 * CALORIES;
    }

    @Override
    void getNutrients() {
        System.out.println(Name + " is full of nutrients.");
    }

    @Override
    String getName() {
        return Name;
    }
}
