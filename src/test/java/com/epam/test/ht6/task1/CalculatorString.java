package com.epam.test.ht6.task1;

import com.epam.test.ht6.task1.test.NegativesAreNotAllowedException;

import java.util.ArrayList;
import java.util.Arrays;

public class CalculatorString {
    public int add(String numbers) throws NegativesAreNotAllowedException {
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

            AreNegativesIncluded(valuesByLine.toArray(new String[valuesByLine.size()]));

            for(var each : valuesByLine){
                result += Integer.parseInt(each);
            }
        }
        else{
            AreNegativesIncluded(valuesByDelim);
            for(var each : valuesByDelim){
                result += Integer.parseInt(each);
            }
        }

        return result;
    }

    public void AreNegativesIncluded(String[] values) throws NegativesAreNotAllowedException{
        ArrayList<String> listOfNegatives = new ArrayList<>();
        for(var each : values){
            if(Integer.parseInt(each) < 0){
                listOfNegatives.add(each);
            }
        }
        if(listOfNegatives.size() != 0){
            throw new NegativesAreNotAllowedException(listOfNegatives.toString());
        }
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
