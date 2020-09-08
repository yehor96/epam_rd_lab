package com.epam.test.ht8.task2;

public class KeyLengthObj extends ParentKey {
    public KeyLengthObj (String key) {
        this.key = key;
    }

    @Override
    public int hashCode() {
        return key.length();
    }
}