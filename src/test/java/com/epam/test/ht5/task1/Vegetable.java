package com.epam.test.ht5.task1;

public abstract class Vegetable implements ICalorie, Comparable<Vegetable> {
    protected String Name;

    final int CALORIES = 5;

    abstract String getName();

    @Override
    public int compareTo(Vegetable another){
        int result = this.Name.compareTo(another.Name);
        //Sorting by first name if last name is same d
        return result == 0 ? this.Name.compareTo(another.Name) : result;
    }

    @Override
    public String toString(){
        return Name;
    }
}
