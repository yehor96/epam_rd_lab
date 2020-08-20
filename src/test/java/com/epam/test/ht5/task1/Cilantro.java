package com.epam.test.ht5.task1;

public class Cilantro extends GreenCulture {
    public Cilantro() {
        name = "Cilantro";
    }

    @Override
    public int getCalories() {
        return 10 * CALORIES;
    }

    @Override
    public void getScent() {
        System.out.println("Cilantro provides good scent.");
    }

    @Override
    String getName() {
        return name;
    }
}
