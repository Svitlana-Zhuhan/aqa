package oop;

import org.w3c.dom.ls.LSOutput;

public class Main {
    public static void main(String[] args) {

        Woman mary = new Woman("Mary", 25, PersonRole.TEACHER);
        Man john = new Man("John", 30, PersonRole.ENGINEER);
        Man bob = new Man("Bob", 35, PersonRole.DOCTOR);

        mary.displayInformation();
        john.displayInformation();
        bob.displayInformation();

        Woman alice = new Woman("Alice", 28, PersonRole.ARTIST);
        alice.displayInformation();

        alice.setRole(PersonRole.OTHER);
        alice.displayInformation();
    }
}
