package com.epam.test.ht5.task1;

public abstract class Vegetable implements ICalorie, Comparable<Vegetable> {
    protected String name;

    final int CALORIES = 5;

    abstract String getName();

    @Override
    public int compareTo(Vegetable another){
        int result = this.name.compareTo(another.name);
        return result == 0 ? this.name.compareTo(another.name) : result;
    }

    @Override
    public String toString(){
        return name;
    }
}
