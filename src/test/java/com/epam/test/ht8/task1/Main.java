package com.epam.test.ht8.task1;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String filePath = "D:\\\\Tech\\\\git\\\\epam_rd_lab\\\\words.csv";
        TextAnalyzer analyzer = new TextAnalyzer();

        while(analyzer.keepRunningApp){
            OperationType operationType = analyzer.getOperation();
            switch(operationType){
                case FREQUENCY:
                    analyzer.frequencyOperation(filePath);
                    break;
                case LENGTH:
                    analyzer.lengthOperation(filePath);
                    break;
                case DUPLICATES:
                    analyzer.duplicatesOperation(filePath);
                    break;
                default:
                    System.out.println("Incorrect operation type.");
            }
            analyzer.keepRunningApp = analyzer.ShouldKeepRunning();
        }

        System.out.println("Thank you for using our application! Goodbye!");
    }
}