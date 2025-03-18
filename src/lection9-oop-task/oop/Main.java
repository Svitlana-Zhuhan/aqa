package oop;

import org.w3c.dom.ls.LSOutput;

public class Main {
    public static void main(String[] args) {

        Person person1 = new Person("John", 30, "Ingeneer");
        Person person2 = new Person("Mary", 25, "Teacher");
        Person person3 = new Person("Bob", 35, "Doctor");
        Person person4 = new Person("Alice", 28, "Architect");

        System.out.println("Personal information: ");
        person1.displayInfo();
        person2.displayInfo();
        person3.displayInfo();
        person4.displayInfo();

        System.out.println("Changed profession for: " + person4.getName());
        person4.changeProfession("Designer");

        System.out.println("Updated info: ");
        person4.displayInfo();
    }

}
