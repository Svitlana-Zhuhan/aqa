import java.util.Scanner;

public class Grade {
    public static String getGrade(int score) {
        switch (score) {
            case 5:
                return "Відмінно";
            case 4:
                return "Добре";
            case 3:
                return "Задовільно";
            case 2:
                return "Незадовільно";
            case 1:
                return "Погано";
            default:
                return "Неправильна оцінка";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть оцінку (від 1 до 5): ");
        if (scanner.hasNextInt()) {
            int score = scanner.nextInt();
            System.out.println("Ваша оцінка: " + getGrade(score));
        } else {
            System.out.println("Помилка: потрібно ввести ціле число.");
        }

        scanner.close();
    }
}