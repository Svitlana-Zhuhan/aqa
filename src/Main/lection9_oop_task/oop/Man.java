package lection9_oop_task.oop;

public class Man extends Person {
    public static final String Gender = "man";

    public Man(String name, int age, PersonRole role) {

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

 //   public static void main(String[] args)
}
