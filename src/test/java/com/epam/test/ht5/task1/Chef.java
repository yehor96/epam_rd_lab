package com.epam.test.ht5.task1;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Chef {
    private Salad salad;

    public Salad cookSalad(){
        salad = new Salad();

        salad.Ingredients = new Vegetable[5];
        salad.Ingredients[0] = new Cilantro();
        salad.Ingredients[1] = new Tomato();
        salad.Ingredients[2] = new Cucumber();
        salad.Ingredients[3] = new Pepper();
        salad.Ingredients[4] = new Garlic();

        return salad;
    }

    public void getIngredientsOrderedByName(Salad salad){
        Arrays.sort(salad.Ingredients);
        for(var each : salad.Ingredients){
            System.out.println(each);
        }
    }

    public int getCalories(Salad salad){
        for(var each : salad.Ingredients) {
            salad.Calories += each.getCalories();
        }

        return salad.Calories;
    }

    public void getIngredientsWithCalories(Salad salad, int from, int to){
        for(var each : salad.Ingredients){
            if((each.getCalories() >= from) && (each.getCalories() <= to)){
                System.out.println(each + "\t" + each.getCalories());
            }
        }
    }

    public void getIngredientsWithCalories(Salad salad){
        for(var each : salad.Ingredients){
                System.out.println(each + "\t" + each.getCalories());
        }
    }
}
