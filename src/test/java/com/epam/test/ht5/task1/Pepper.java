package com.epam.test.ht5.task1;

public class Pepper extends FruitVegetable {
    public Pepper() {
        name = "Pepper";
    }

    @Override
    public int getCalories() {
        return 8 * CALORIES;
    }

    @Override
    String getName() {
        return name;
    }

    @Override
    void getTaste(){
        System.out.println(name + " tastes bitter.");
    }
}
