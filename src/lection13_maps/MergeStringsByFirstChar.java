package lection13_maps;

import java.util.HashMap;
import java.util.Map;

public class MergeStringsByFirstChar {
    public static Map<String, String> mergeStringsByFirstChar(String[] strings) {
        Map<String, String> result = new HashMap<>();

        if (strings == null || strings.length == 0) {
            return result;
        }
        for (String str : strings) {
            if (!str.isEmpty()) {
                String firstChar = String.valueOf(str.charAt(0));
                result.put(firstChar, result.getOrDefault(firstChar, "") + str);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        String[] arr1 = {"salt", "tea", "soda", "toast"};
        String[] arr2 = {"aa", "bb", "cc", "aAA", "cCC", "d"};
        String[] arr3 = {};

        System.out.println(mergeStringsByFirstChar(arr1));
        System.out.println(mergeStringsByFirstChar(arr2));
        System.out.println(mergeStringsByFirstChar(arr3));
    }
}
