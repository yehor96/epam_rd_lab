package com.epam.test.ht5.task1;

public class Tomato extends FruitVegetable {
    public Tomato() {
        name = "Tomato";
    }

    @Override
    public int getCalories() {
        return 12 * CALORIES;
    }

    @Override
    String getName() {
        return name;
    }
}
