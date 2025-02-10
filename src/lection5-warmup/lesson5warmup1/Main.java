package lesson5warmup1;

public class Main {
    public static String checkAge(int age) {
       if (age >= 18) {
           return "Ви доросла особа";
       } else {
           return "Ви не є дорослою особою";
       }
    }

public static void main(String[] args) {
    System.out.println(checkAge(18));
    System.out.println(checkAge(0));
    System.out.println(checkAge(99));
}

}
