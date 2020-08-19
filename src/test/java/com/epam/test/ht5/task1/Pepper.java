package com.epam.test.ht5.task1;

public class Pepper extends FruitVegetable {
    public Pepper() {
        Name = "Pepper";
    }

    @Override
    public int getCalories() {
        return 8 * CALORIES;
    }

    @Override
    String getName() {
        return Name;
    }

    @Override
    void getTaste(){
        System.out.println(Name + " tastes bitter.");
    }
}
