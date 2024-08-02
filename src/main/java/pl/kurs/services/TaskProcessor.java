package pl.kurs.services;

import pl.kurs.models.Child;
import pl.kurs.models.BabyGender;
import pl.kurs.models.Mother;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskProcessor {
    private final List<Mother> motherList;
    private final List<Child> childList;

    public TaskProcessor(List<Mother> motherList, List<Child> childList) {
        this.motherList = motherList;
        this.childList = childList;
    }

    ///////////////////// a)
    public void displayTallestChildren() {
        Child tallestBoy = getTallestBoy();
        Child tallestGirl = getTallestGirl();
        if (tallestBoy != null) {
            System.out.println("Największy chłopiec: " + tallestBoy.getName() + " ma wzrostu " + tallestBoy.getHeightCm() + "cm");
        }
        if (tallestGirl != null) {
            System.out.println("Największa dziewczynka: " + tallestGirl.getName() + " ma wzrostu " + tallestGirl.getHeightCm() + "cm");
        }
    }

    private Child getTallestBoy() {
        Child tallestBoy = null;
        for (Child child : childList) {
            if (child.getGender() == BabyGender.SON) {
                if (tallestBoy == null || child.getHeightCm() > tallestBoy.getHeightCm()) {
                    tallestBoy = child;
                }
            }
        }
        return tallestBoy;
    }

    private Child getTallestGirl() {
        Child tallestGirl = null;
        for (Child child : childList) {
            if (child.getGender() == BabyGender.DAUGHTER) {
                if (tallestGirl == null || child.getHeightCm() > tallestGirl.getHeightCm()) {
                    tallestGirl = child;
                }
            }
        }
        return tallestGirl;
    }

    ////////////////////////// b)
    public void printDayOfWeekOfMostBirths() {
        Map<String, Integer> dayOfWeekCount = countBirthsByDayOfWeek();
        String mostCommonDay = findDayWithMostBirths(dayOfWeekCount);

        if (mostCommonDay != null) {
            System.out.println("Najwięcej dzieci urodziło się w: " + mostCommonDay + " i było ich: " + dayOfWeekCount.get(mostCommonDay));
        }
    }

    private Map<String, Integer> countBirthsByDayOfWeek() {
        Map<String, Integer> dayOfWeekCount = new HashMap<>();
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE");


        for (Child child : childList) {
            String dayOfWeek = sdf.format(child.getDateOfBirth());
            dayOfWeekCount.put(dayOfWeek, dayOfWeekCount.getOrDefault(dayOfWeek, 0) + 1);
        }
        return dayOfWeekCount;
    }

    private String findDayWithMostBirths(Map<String, Integer> dayOfWeekCount) {
        String mostCommonDay = null;
        int maxCount = 0;

        for (Map.Entry<String, Integer> entry : dayOfWeekCount.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostCommonDay = entry.getKey();
            }
        }
        return mostCommonDay;
    }

    ////////////////////////////////// c)
    public void printYoungMothersWithHeavyChildren() {
        for (Mother mother : motherList) {
            if (mother.getAge() < 25) {
                for (Child child : mother.getChildList()) {
                    if (child.getWeightG() > 4000) {
                        System.out.println(mother.getName() + " urodziła dziecko ważące ponad 4000g");
                    }
                }
            }
        }
    }

    //////////////////////////////// d)
    public void printDaughtersWithInheritedName() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        for (Mother mother : motherList) {
            for (Child child : mother.getChildList()) {
                if (child.getGender()== BabyGender.DAUGHTER && child.getName().equals(mother.getName())) {
                    System.out.println("Dziewczynka: " + child.getName() + " odziedziczyła imię po matce i jest urodzona: " + sdf.format(child.getDateOfBirth()));
                }
            }
        }
    }

    /////////////////////////////////// e)
    public void printMothersWithTwins() {
        for (Mother mother : motherList) {
            if (hasTwins(mother)) {
                System.out.println("Matka " + mother.getName() + " ma bliźniaki");
            }
        }
    }
    private boolean hasTwins(Mother mother){
        Map<String, Integer> birthDateCount = new HashMap<>();
        SimpleDateFormat sdf = new SimpleDateFormat();
        for (Child child : mother.getChildList()) {
            String birthDate = sdf.format(child.getDateOfBirth());
            birthDateCount.put(birthDate, birthDateCount.getOrDefault(birthDate, 0) + 1);
        }

        for (int count : birthDateCount.values()) {
            if (count == 2) {
                return true;
            }
        }
        return false;

    }


}