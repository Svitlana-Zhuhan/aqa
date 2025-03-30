package lection9_oop_task.oop;

public abstract class Person implements Displayable {

    private String name;
    private int age;
    private PersonRole role;

    public Person(String name, int age, PersonRole role) {
        if (name == null || name.trim().isEmpty()) {
            throw new NameRequiredException("Name cannot be empty");
        }
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        this.name = name;
        this.age = age;
        this.role = role;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NameRequiredException("Name cannot be empty");
        }
        this.name = name;
    }

    public String getName() {

        return name;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
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
//        System.out.println("Ім'я: " + name + ", Вік: " + age + ", Професія: " + role);
    }

    public abstract String getGender();
}
