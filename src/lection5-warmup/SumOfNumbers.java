import java.util.Scanner;

public class SumOfNumbers {

    public static String calculateSumUpToN(int n) {
        if (n <= 0) {
            return "Хибні вхідні параметри";
        }

        StringBuilder result = new StringBuilder();
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            sum += i;
            result.append(i);
            if (i < n) {
                result.append(" ");
            }
        }

        return result.toString().trim() + " = " + sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть число N: ");
        int N = scanner.nextInt();

        System.out.println(calculateSumUpToN(N));
    }
}
