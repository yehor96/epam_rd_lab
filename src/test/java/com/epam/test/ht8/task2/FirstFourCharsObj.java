package com.epam.test.ht8.task2;

public class FirstFourCharsObj extends ParentKey {
    public FirstFourCharsObj (String key) {
        this.key = key;
    }

    @Override
    public int hashCode() {
        if(key.length() < 4){
            return Integer.parseInt(key);
        }

        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < 4; i++){
            builder.append(key.toCharArray()[i]);
        }

        return Integer.parseInt(builder.toString());
    }
}