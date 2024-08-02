package pl.kurs.models;

import java.util.ArrayList;
import java.util.List;

public class Mother {
    private final int id;
    private final String name;
    private final int age;
    private final List<Child> childList = new ArrayList<>();

    public Mother(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<Child> getChildList() {
        return childList;
    }
    public void addChild(Child child){
        childList.add(child);
    }

    @Override
    public String toString() {
        return "Mother{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", childList=" + childList +
                '}';
    }
}