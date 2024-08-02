package pl.kurs.services;

import pl.kurs.models.Child;
import pl.kurs.models.BabyGender;
import pl.kurs.models.Mother;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;

public class DataProcessor {
    private final List<Mother> motherList = new ArrayList<>();
    private final List<Child> childList = new ArrayList<>();

    public DataProcessor(String mothersFile, String newbornsFile) throws IOException, ParseException {
        loadMothers(mothersFile);
        loadChildren(newbornsFile);
    }

    private void loadMothers(String mothersFile) {
        try (
                BufferedReader br = new BufferedReader(new FileReader(mothersFile))
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                int age = Integer.parseInt(parts[2]);
                Mother mother = new Mother(id, name, age);
                motherList.add(mother);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadChildren(String newbornsFile) {
        try (
                BufferedReader br = new BufferedReader(new FileReader(newbornsFile))
        ) {
            String line;
            Map<Integer, Mother> motherMap = new HashMap<>();
            for (Mother mother : motherList) {
                motherMap.put(mother.getId(), mother);
            }
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                int id = Integer.parseInt(parts[0]);
                BabyGender babyGender = BabyGender.getBabyGenderFromString(parts[1]);
                String name = parts[2];
                String dateOfBirth = parts[3];
                int weight = Integer.parseInt(parts[4]);
                int height = Integer.parseInt(parts[5]);
                int motherId = Integer.parseInt(parts[6]);
                Mother mother = motherMap.get(motherId);
                Child child = new Child(id, babyGender, name, dateOfBirth, weight, height, mother);
                mother.addChild(child);
                childList.add(child);

            }
        }catch (IOException | ParseException e){
            e.printStackTrace();
        }
    }

    public List<Mother> getMotherList() {
        return Collections.unmodifiableList(motherList);
    }

    public List<Child> getChildList() {
        return Collections.unmodifiableList(childList);
    }
}