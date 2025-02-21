import java.util.Arrays;
import java.util.Scanner;

public class ArrayOperations {public static double calculateAverage(int[] array) {
    if (array == null || array.length == 0) {
        throw new IllegalArgumentException("Масив не може бути пустим або null");
    }
    int sum = 0;
    for (int num : array) {
        sum += num;
    }
    return (double) sum / array.length;
}


    public static int findMax(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Масив не може бути пустим або null");
        }
        int max = array[0];
        for (int num : array) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }


    public static int findMin(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Масив не може бути пустим або null");
        }
        int min = array[0];
        for (int num : array) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }


    public static void printArrayReverse(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Масив не може бути пустим або null");
        }
        for (int i = array.length - 1; i >= 0; i--) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }


    public static boolean isNumberPresent(int[] array, int number) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Масив не може бути пустим або null");
        }
        for (int num : array) {
            if (num == number) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Введіть розмір масиву: ");
        int size = scanner.nextInt();
        int[] array = new int[size];
        System.out.println("Введіть елементи масиву:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }


        double average = calculateAverage(array);
        System.out.println("Середнє значення: " + average);


        int max = findMax(array);
        int min = findMin(array);
        System.out.println("Максимальне значення: " + max);
        System.out.println("Мінімальне значення: " + min);


        System.out.println("Елементи масиву в зворотньому порядку:");
        printArrayReverse(array);


        System.out.print("Введіть число для перевірки: ");
        int number = scanner.nextInt();
        if (isNumberPresent(array, number)) {
            System.out.println("Число " + number + " присутнє в масиві.");
        } else {
            System.out.println("Число " + number + " відсутнє в масиві.");
        }

        scanner.close();
    }
}
