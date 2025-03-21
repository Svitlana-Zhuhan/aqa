package lection13_maps;

import java.util.HashMap;
import java.util.Map;

public class WordCount {

    public static Map<String, Integer> countWords(String[] strings) {
        Map<String, Integer> wordCounts = new HashMap<>();

        if (strings == null || strings.length == 0) {
            return wordCounts;
        }

        for (String str : strings) {
            wordCounts.put(str, wordCounts.getOrDefault(str, 0) +1);
        }

        return wordCounts;
    }

    public static void main(String[] args) {

        String[] arr1 = {"a", "b", "a", "c", "b"};
        String[] arr2 = {"c", "b", "a"};
        String[] arr3 = {"c", "c", "c", "c"};

        System.out.println(countWords(arr1));
        System.out.println(countWords(arr2));
        System.out.println(countWords(arr3));
    }
}
