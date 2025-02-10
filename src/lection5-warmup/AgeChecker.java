import java.util.Scanner;

public class AgeChecker {
    public static void  main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть свій вік:");
        int age = new Scanner(System.in).nextInt();
        if (age >= 18) {
            System.out.println("Ви доросла особа");
        } else {
            System.out.println("Ви не є дорослою особою");
        }
        scanner.close();
    }
}

