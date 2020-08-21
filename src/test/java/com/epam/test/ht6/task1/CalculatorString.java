package com.epam.test.ht6.task1;

import java.util.ArrayList;
import java.util.Arrays;

public class CalculatorString {
    public int add(String numbers){
        if(numbers.equals("")){
            return 0;
        }

        int result = 0;
        String delimiter = ",";
        boolean withDelimiter = false;
        if((numbers.charAt(0) == '/') && (numbers.charAt(1) == '/') && (numbers.charAt(3) == '\n')){
            delimiter = numbers.substring(2,3);
            withDelimiter = true;
        }

        if(withDelimiter) {
            numbers = numbers.substring(4);
        }

        String[] valuesByDelim = numbers.split(delimiter);

        if(numbers.contains("\n")){
        ArrayList<String> valuesByLine = getNumbersIfSeparatedByLine(valuesByDelim);

            for(var each : valuesByLine){
                result += Integer.parseInt(each);
            }
        }
        else{
            for(var each : valuesByDelim){
                result += Integer.parseInt(each);
            }
        }

        return result;
    }

    public ArrayList<String> getNumbersIfSeparatedByLine(String[] array) {
        ArrayList<String> list = new ArrayList<>();

        for (var each : array) {
            if (each.contains("\n")) {
                list.addAll(Arrays.asList(each.split("\\u000A")));
            }
            else{
                list.add(each);
            }
        }

        return list;
    }
}
