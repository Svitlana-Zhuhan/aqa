public class Main {

    public static void printSquare(int number) {
        System.out.println("Квадрат числа " + number + " = " + (number * number));
    }

    public static double cylinderVolume(double radius, double height) {
        return Math.PI * Math.pow(radius, 2) * height;
    }

    public static int power(int a, int b) {
        return (int) Math.pow(a, b);
    }

    public static void main(String[] args) {
        printSquare(5);

        double volume = cylinderVolume(3.5, 10);
        System.out.println("Об'єм циліндра: " + volume);

        int result = power(2, 5);
        System.out.println("2^5 = " + result);
    }
}

