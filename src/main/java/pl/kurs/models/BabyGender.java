package pl.kurs.models;

public enum BabyGender {
    DAUGHTER, SON;

    public static BabyGender getBabyGenderFromString(String gender) {
        return switch (gender) {
            case "c" -> DAUGHTER;
            case "s" -> SON;
            default -> throw new IllegalArgumentException("Nieprawidłowa płeć: " + gender);
        };
    }
}