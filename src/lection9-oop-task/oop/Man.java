package oop;

public class Man extends Person {
    public static final String Gender = "man";

    public Man(String name, int age, PersonRole role) {
        super(name, age, role);
    }

    @Override
    public void displayInformation() {
        super.displayInformation();
        System.out.println("Gender: " + Gender);
    }
}
