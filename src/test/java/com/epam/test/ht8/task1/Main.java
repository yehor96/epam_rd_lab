package com.epam.test.ht8.task1;

import java.io.FileNotFoundException;

import static com.epam.test.ht8.task1.ConsoleOperator.print;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String filePath = ".\\additional_files\\words.csv";
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
                    print("Incorrect operation type.");
            }
            analyzer.keepRunningApp = analyzer.ShouldKeepRunning();
        }

        print("Thank you for using our application! Goodbye!\n");
    }
}