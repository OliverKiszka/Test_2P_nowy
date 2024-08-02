package pl.kurs.app;

import pl.kurs.services.DataProcessor;
import pl.kurs.services.TaskProcessor;

import java.io.IOException;
import java.text.ParseException;

public class Runner {
    public static void main(String[] args) {
        String mothersFile = "mamy.txt";
        String newbornsFile = "noworodki.txt";
        try {
            DataProcessor dp = new DataProcessor(mothersFile, newbornsFile);
            TaskProcessor tp = new TaskProcessor(dp.getMotherList(), dp.getChildList());

            System.out.println("*************TASK1**************");
            tp.displayTallestChildren();
            System.out.println("*************TASK2**************");
            tp.printDayOfWeekOfMostBirths();
            System.out.println("*************TASK3**************");
            tp.printYoungMothersWithHeavyChildren();
            System.out.println("*************TASK4**************");
            tp.printDaughtersWithInheritedName();
            System.out.println("*************TASK5**************");
            tp.printMothersWithTwins();
        }catch (IOException | ParseException e){
            e.printStackTrace();
        }
    }
}