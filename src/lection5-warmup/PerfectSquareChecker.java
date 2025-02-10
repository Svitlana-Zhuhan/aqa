import java.util.Scanner;

public class PerfectSquareChecker {
    public static boolean isPerfectSquare(int number) {
        if (number < 0) {
            return false;
        }
        int sqrt = (int) Math.sqrt(number);
        return sqrt * sqrt == number;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть число: ");
        int number = scanner.nextInt();

        if (isPerfectSquare(number)) {
            System.out.println(number + " є ідеальним квадратом.");
        } else {
            System.out.println(number + " не є ідеальним квадратом.");
        }

        scanner.close();
    }
}
