package com.epam.test.ht5.task1;

import java.io.Serializable;
import java.util.Arrays;

public class Chef implements Serializable {
    private transient Salad salad;

    public void setSalad(Salad salad){
        this.salad = salad;
    }

    public Salad cookSalad(){
        salad = new Salad();

        salad.ingredients = new Vegetable[5];
        salad.ingredients[0] = new Cilantro();
        salad.ingredients[1] = new Tomato();
        salad.ingredients[2] = new Cucumber();
        salad.ingredients[3] = new Pepper();
        salad.ingredients[4] = new Garlic();

        salad.mixUpSalad();
        return salad;
    }

    public void getIngredientsOrderedByName(Salad salad){
        Arrays.sort(salad.ingredients);
        for(var each : salad.ingredients){
            System.out.println(each);
        }
    }

    public int getCalories(Salad salad){
        return salad.calories;
    }

    public void getIngredientsWithCalories(Salad salad, int from, int to){
        for(var each : salad.ingredients){
            if((each.getCalories() >= from) && (each.getCalories() <= to)){
                System.out.println(each + "\t" + each.getCalories());
            }
        }
    }

    public void getIngredientsWithCalories(Salad salad){
        for(var each : salad.ingredients){
                System.out.println(each + "\t" + each.getCalories());
        }
    }
}
