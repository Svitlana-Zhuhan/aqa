package lection9_oop_task.oop;

public class Woman extends Person {
    public static final String Gender = "woman";

    public Woman(String name, int age, PersonRole role) {

        super(name, age, role);
    }

    @Override
    public void displayInformation() {
//        super.displayInformation();
//        System.out.println("Gender: " + Gender);
           System.out.println("Name: " + getName() + ", Age:" + getAge() + ", Gender: " + getGender());
    }

    @Override
    public String getGender() {

        return Gender;
    }
}
