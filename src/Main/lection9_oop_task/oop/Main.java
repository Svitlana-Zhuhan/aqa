package lection9_oop_task.oop;

import org.w3c.dom.ls.LSOutput;

import javax.lang.model.element.Name;

public class Main {
    public static void main(String[] args) {
        try {
            Woman woman1 = new Woman("Nora", 27, PersonRole.ARTIST);
            woman1.displayInformation("Woman1 information: ");

            Woman woman2 = new Woman(null, 22, PersonRole.OTHER);
            woman2.displayInformation("Woman2 information: ");
        } catch (NameRequiredException e) {
            System.err.println("Name error while creating a woman: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Age error while creating a woman: " + e.getMessage());
        }

        try {
            Woman woman3 = new Woman("Kate", -23, PersonRole.DOCTOR);
            woman3.displayInformation("Woman3 information: ");
        } catch (NameRequiredException e) {
            System.err.println("Name error while creating a woman: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Age error while creating a woman: " + e.getMessage());
        }

        Woman mary = new Woman("Mary", 25, PersonRole.TEACHER);
        Man john = new Man("John", 30, PersonRole.ENGINEER);
        Man bob = new Man("Bob", 35, PersonRole.DOCTOR);
       // Man null = new Man("null", 27, PersonRole.ARTIST);
        //Woman nora = new Woman("Nora", -20, PersonRole.OTHER);

        mary.displayInformation();
        john.displayInformation();
        bob.displayInformation();
      //  null.displayInformation();
      //  nora.displayInformation();

        Woman alice = new Woman("Alice", 28, PersonRole.ARTIST);
        alice.displayInformation();

        alice.setRole(PersonRole.OTHER);
        alice.displayInformation();
    }

}
