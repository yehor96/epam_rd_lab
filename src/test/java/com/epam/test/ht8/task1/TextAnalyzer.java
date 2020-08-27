package com.epam.test.ht8.task1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import static java.util.stream.Collectors.toMap;

public class TextAnalyzer {

    public TextAnalyzer() {
        operationType = null;
        keepRunningApp = true;
    }

    public boolean keepRunningApp;
    private OperationType operationType;
    private Scanner scanner;

    public void frequencyOperation(String path) throws FileNotFoundException {
        scanner = new Scanner(new File(path));

        Map<String, Integer> words = new HashMap<>();
        while (scanner.hasNext()) {
            String word = scanner.useDelimiter(",").next();
            Integer count = words.get(word);
            if (count == null) {
                count = 0;
            }
            words.put(word, ++count);
        }

        for(int i = 0; i < 2; i++){
            System.out.println(sortInDescendingOrderByValue(words).entrySet().toArray()[i]);
        }
    }

    public void lengthOperation(String path) throws FileNotFoundException {
        scanner = new Scanner(new File(path));

        Map<String, Integer> words = new HashMap<>();
        while (scanner.hasNext()) {
            String word = scanner.useDelimiter(",").next();
            words.put(word, word.length());
        }

        for(int i = 0; i < 3; i++){
            System.out.println(sortInDescendingOrderByValue(words).entrySet().toArray()[i]);
        }
    }

    public void duplicatesOperation(String path) throws FileNotFoundException {
        scanner = new Scanner(new File(path));

        Map<String, Integer> words = new HashMap<>();
        ArrayList<String> dupes = new ArrayList<>();
        int counter = 0;

        while (counter < 3) {
            String word = scanner.useDelimiter(",").next();
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

        String reverse = "";
        Map<String, Integer> dupesModified = new HashMap<>();

        for(var each : dupes) {
            for(int i = each.length() - 1; i >= 0; i--)
            {
                reverse = reverse + each.charAt(i);
            }
            dupesModified.put(reverse, reverse.length());
            reverse = "";
        }

        dupesModified.keySet().forEach((w) -> System.out.println(w.toUpperCase()));
    }

    public boolean ShouldKeepRunning(){
        scanner = new Scanner(System.in);
        String entry = "";

        while(!(entry.toLowerCase().equals("y") || entry.toLowerCase().equals("n"))){
            System.out.print("Would you like to run the application again? Enter \"y\" for YES or \"n\" for NO:     ");
            entry = scanner.nextLine();
        }
        return entry.equals("y") ? true : false;
    }

    public OperationType getOperation(){
        scanner = new Scanner(System.in);
        boolean correctEntry = false;
        String prompt = "Enter one of possible operations: \n" +
                "1 - for 'Get two words that are used most often.'\n" +
                "2 - for 'Get three longest words.'\n" +
                "3 - for 'Get first three duplicates reversed.'\n";
        do {
            System.out.println(prompt);
            String entry = scanner.nextLine();

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
                    System.out.println("Incorrect Entry! Make sure to enter value within 0 - 4.");
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
