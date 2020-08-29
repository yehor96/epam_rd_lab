package com.epam.test.ht5.task1;

import java.io.Serializable;

public class Salad implements Serializable {
    public Vegetable[] ingredients;

    public int calories;

    public void mixUpSalad(){
        for(var each : ingredients) {
            calories += each.getCalories();
        }
    }
}
