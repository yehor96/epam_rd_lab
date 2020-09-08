package com.epam.test.ht8.task2;

import java.util.*;

public class Main {

    public static void main(String[] args){
        KeyLengthObj obj1 = new KeyLengthObj("12");
        KeyLengthObj obj2 = new KeyLengthObj("123");
        FirstFourCharsObj obj3 = new FirstFourCharsObj("12345");
        FirstFourCharsObj obj4 = new FirstFourCharsObj("123456");
        FirstFourCharsObj obj5 = new FirstFourCharsObj("0");

        Map<ParentKey, String> hashMap = new HashMap<>();
        Map<ParentKey, String> linkedHashMap = new LinkedHashMap<>();

        hashMap.put(obj1, "Text1");
        hashMap.put(obj2, "Text2");
        hashMap.put(obj3, "Text3");
        hashMap.put(obj4, "Text4");
        hashMap.put(obj5, "Text5");

        linkedHashMap.put(obj1, "Text1");
        linkedHashMap.put(obj2, "Text2");
        linkedHashMap.put(obj3, "Text3");
        linkedHashMap.put(obj4, "Text4");
        linkedHashMap.put(obj5, "Text5");

        Set entrySetHash = hashMap.entrySet();
        System.out.println(hashMap.getClass().getSimpleName());
        displayMap(entrySetHash);

        Set entrySetLinked = linkedHashMap.entrySet();
        System.out.println(linkedHashMap.getClass().getSimpleName());
        displayMap(entrySetLinked);
    }

    public static void displayMap(Set set){
        Iterator iteratorLinked = set.iterator();
        while(iteratorLinked.hasNext()){
            Map.Entry entry = (Map.Entry)iteratorLinked.next();
            System.out.println("Key:    " + entry.getKey() + "\t" + "Value: " + entry.getValue());
        }
        System.out.println();
    }
}
