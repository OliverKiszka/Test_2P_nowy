package pl.kurs.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Child {
    private final int id;
    private final BabyGender babyGender;
    private final String name;
    private final Date dateOfBirth;
    private final int weightG;
    private final int heightCm;
    private final Mother mother;
    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public Child(int id, BabyGender babyGender, String name, String dateOfBirth, int weightG, int heightCm, Mother mother) throws ParseException {
        this.id = id;
        this.babyGender = babyGender;
        this.name = name;
        this.dateOfBirth = sdf.parse(dateOfBirth);
        this.weightG = weightG;
        this.heightCm = heightCm;
        this.mother = mother;
    }

    public int getId() {
        return id;
    }

    public BabyGender getGender() {
        return babyGender;
    }

    public String getName() {
        return name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public int getWeightG() {
        return weightG;
    }

    public int getHeightCm() {
        return heightCm;
    }

    public Mother getMother() {
        return mother;
    }

    @Override
    public String toString() {
        return "Child{" +
                "id=" + id +
                ", gender=" + babyGender +
                ", name='" + name + '\'' +
                ", dateOfBirth=" + sdf.format(dateOfBirth) +
                ", weight=" + weightG +
                ", height=" + heightCm +
                ", mother=" + mother.getName() +
                '}';
    }
}