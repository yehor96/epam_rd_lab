package com.epam.test.ht5.task1;

public class Cucumber extends FruitVegetable  {
    public Cucumber() {
        name = "Cucumber";
    }

    @Override
    public int getCalories() {
        return 5 * CALORIES;
    }

    @Override
    String getName() {
        return name;
    }
}
