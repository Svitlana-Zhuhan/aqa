package lection13_maps;

import java.util.HashMap;
import java.util.Map;

public class FirstLastChar {
    public static Map<String, String> createMap(String[] strings) {
        Map<String, String> map = new HashMap<>();

        if (strings == null || strings.length == 0) {
            return map;
        }

        for (String str : strings) {
            if (str.length() > 0) {
                map.put(String.valueOf(str.charAt(0)), String.valueOf(str.charAt(str.length() - 1)));
            }
        }

        return map;
    }

    public static void main(String[] args) {
        String[] arr1 = {"code", "bug"};
        String[] arr2 = {"man", "moon", "main"};
        String[] arr3 = {"man", "moon", "good", "night"};

        System.out.println(createMap(arr1));
        System.out.println(createMap(arr2));
        System.out.println(createMap(arr3));
    }
}
