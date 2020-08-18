package com.epam.test.ht2.task2_2;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        final String PATTERN = "[${]+[^$]+[}]";

        System.out.print("Enter template: ");
        String entry = in.nextLine();

        Pattern pattern = Pattern.compile(PATTERN);
        Matcher matcher = pattern.matcher(entry);

        ArrayList<String> placeholders = new ArrayList<>();
        int counter = 0;
        while (matcher.find()) {
            placeholders.add(matcher.group().substring(2, matcher.group().length() - 1));
            counter++;
        }

        if(counter==0){
            System.out.println("Error, unable to find template");
            return;
        }

        ArrayList<String> values = new ArrayList<>();
        for (String p : placeholders) {
            System.out.print("Enter value for \"" + p + "\" placeholder: ");
            values.add(in.nextLine());
        }

        StringBuilder builder = new StringBuilder();
        int counting = 0;
        for(String text : entry.split(PATTERN)) {
            builder.append(text);
            if (counting < values.size()) {
                builder.append(values.toArray()[counting]);
                counting++;
            }
        }

        System.out.println(builder);
    }
}
