package com.epam.test.ht8.task2;

abstract public class ParentKey {
    protected String key;

    @Override
    public String toString(){
        return String.valueOf(hashCode());
    }
}
