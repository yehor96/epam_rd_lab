package com.epam.test.ht3.task2;

import java.util.ArrayList;
import java.util.Scanner;

//Variant #6
public class Main {

    public static void main(String[] args) {
        String entry = getWords();

        ArrayList<String> digitWords = findWordsWithDigitsOnly(entry);

        printDigitWord(digitWords);
    }

    public static String getWords(){
        Scanner scanner = new Scanner(System.in);
        String text;

        System.out.println("Please enter some words on the next line. It cannot be left blank: ");
        text = scanner.nextLine();

        while(text.isBlank()) {
            System.out.println("You did not enter anything! Please try once again: ");
            text = scanner.nextLine();
        }

        return text;
    }

    public static ArrayList<String> findWordsWithDigitsOnly(String text){
        String[] allWords = text.split(" ");

        ArrayList<String> digitWords = new ArrayList<>();
        boolean flag;

        for(var word : allWords){
            flag = true;
            for(var symbol : word.toCharArray()) {
                if(!Character.isDigit(symbol)){
                    flag = false;
                    break;
                }
            }
            if(flag){
                digitWords.add(word);
            }
        }
        return digitWords;
    }

    public static void printDigitWord(ArrayList<String> words){
        if(words.size() > 1){
            System.out.println("The second digit word is: " + words.get(1));
        }
        else if (words.size() == 0){
            System.out.println("There are no digit words in entered text!");
        }
        else {
            System.out.println("The only digit word is: " + words.get(0));
        }
    }
}
