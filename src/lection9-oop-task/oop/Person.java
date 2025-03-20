package oop;

public abstract class Person implements Displayable {

    private String name;
    private int age;
    private PersonRole role;

    public Person(String name, int age, PersonRole role) {
        this.name = name;
        this.age = age;
        this.role = role;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setRole(PersonRole role) {
        this.role = role;
    }

    public PersonRole getRole() {
        return role;
    }

    @Override
    public abstract void displayInformation();
    public void displayInformation(String prefix) {
        System.out.println(prefix + ": ");
        displayInformation();
    }

    public abstract String getGender();
}
