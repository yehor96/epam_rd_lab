package com.epam.test.ht8.task1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import static com.epam.test.ht8.task1.InputOutputHelper.*;
import static java.util.stream.Collectors.toMap;

public class TextAnalyzer {
    public boolean keepRunningApp = true;
    private OperationType operationType;

    public void frequencyOperation(String path) throws FileNotFoundException {
        readFile(new File(path));

        Map<String, Integer> words = new HashMap<>();
        while (hasMoreElements()) {
            String word = getNextElement();
            Integer count = words.get(word);
            if (count == null) {
                count = 0;
            }
            words.put(word, ++count);
        }

        for(int i = 0; i < 2; i++){
            print(sortInDescendingOrderByValue(words)
                    .entrySet()
                    .toArray()[i]
                    .toString() + "\n"
            );
        }
    }

    public void lengthOperation(String path) throws FileNotFoundException {
        readFile(new File(path));

        Map<String, Integer> words = new HashMap<>();
        while (hasMoreElements()) {
            String word = getNextElement();
            words.put(word, word.length());
        }

        for(int i = 0; i < 3; i++){
            print(sortInDescendingOrderByValue(words)
                    .entrySet()
                    .toArray()[i]
                    .toString() + "\n"
            );
        }
    }

    public void duplicatesOperation(String path) throws FileNotFoundException {
        readFile(new File(path));

        Map<String, Integer> words = new HashMap<>();
        ArrayList<String> dupes = new ArrayList<>();
        int counter = 0;

        while (counter < 3) {
            String word = getNextElement();
            Integer count = words.get(word);
            if (count == null) {
                count = 0;
            }
            if(words.containsKey(word)){
                dupes.add(word);
                counter++;
            }
            words.put(word, ++count);
        }

        Map<String, Integer> dupesModified = new HashMap<>();

        for(var each : dupes) {
            String reverse = new StringBuilder(each).reverse().toString();
            dupesModified.put(reverse, reverse.length());
        }

        dupesModified.keySet().forEach((w) -> print(w.toUpperCase() + "\n"));
    }

    public boolean ShouldKeepRunning(){
        String entry = "";

        while(!(entry.toLowerCase().equals("y") || entry.toLowerCase().equals("n"))){
            entry = getInput("Would you like to run the application again? Enter \"y\" for YES or \"n\" for NO:     ");
        }
        return entry.equals("y");
    }

    public OperationType getOperation(){
        boolean correctEntry = false;
        String prompt = "Enter one of possible operations: \n" +
                "1 - for 'Get two words that are used most often.'\n" +
                "2 - for 'Get three longest words.'\n" +
                "3 - for 'Get first three duplicates reversed.'\n";
        do {
            String entry = getInput(prompt + "\n");
            switch (entry) {
                case "1":
                    operationType = OperationType.FREQUENCY;
                    correctEntry = true;
                    break;
                case "2":
                    operationType = OperationType.LENGTH;
                    correctEntry = true;
                    break;
                case "3":
                    operationType = OperationType.DUPLICATES;
                    correctEntry = true;
                    break;
                default:
                    print("Incorrect Entry! Make sure to enter value within 0 - 4." + "\n");
            }
        }while(!correctEntry);

        return operationType;
    }

    private Map<String,Integer> sortInDescendingOrderByValue(Map<String, Integer> words){
        return words
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(
                        toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2,
                                LinkedHashMap::new));
    }
}
