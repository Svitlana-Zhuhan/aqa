package lection12_collections;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 14, 15, 92, 6);
        System.out.println("Numbers collection: " + numbers);

        System.out.println("***");

        List<String> fullName = Arrays.asList("Zhuhan", "Svitlana", "Ivanivna");
        System.out.println("Strings collection: " + fullName);

        System.out.println("***");

        Set<String> uniqueStrings = new LinkedHashSet<>();
        uniqueStrings.add("string1");
        uniqueStrings.add("string2");
        uniqueStrings.add("string3");
        uniqueStrings.add("string1");
        System.out.println("Unique strings set: " + uniqueStrings);

        System.out.println("***");

        Map<String, String> phone = new HashMap<>();

        phone.put("Kyiv", "044");
        phone.put("Dnipro", "056");
        phone.put("Kharkiv", "057");
        phone.put("Odesa", "048");

        for (String name : phone.keySet()) {
            System.out.println(name + "'s phone code is " + phone.get(name));
        }

    }
}
