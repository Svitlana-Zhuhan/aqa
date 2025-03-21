package lection13_maps;

import java.util.HashMap;
import java.util.Map;

public class LengthOfStrings {
    public static Map<String, Integer> getLengthOfStrings(String[] strings) {
        Map<String, Integer> result = new HashMap<>();

        for (String str : strings) {
            result.put(str, str.length());
        }

        return result;
    }

    public static void main(String[] args) {
        String[] arr1 = {"a", "bb", "a", "bb"};
        String[] arr2 = {"this", "and", "that", "and"};
        String[] arr3 = {"code", "code", "code", "bug"};

        System.out.println(getLengthOfStrings(arr1));
        System.out.println(getLengthOfStrings(arr2));
        System.out.println(getLengthOfStrings(arr3));
    }
}
