package oop;

public class Woman extends Person {
    public static final String Gender = "woman";

    public Woman(String name, int age, PersonRole role) {
        super(name, age, role);
    }

    @Override
    public void displayInformation() {
        super.displayInformation();
        System.out.println("Gender: " + Gender);
    }
}
