package oop;

public class Man extends Person {
    public static final String Gender = "man";

    public Man(String name, int age, PersonRole role) {
        super(name, age, role);
    }

    @Override
    public void displayInformation() {
        System.out.println("Name: " + getName() + ", Age:" + getAge() + ", Gender: " + getGender());
    }

    @Override
    public String getGender() {
        return Gender;
    }
}
