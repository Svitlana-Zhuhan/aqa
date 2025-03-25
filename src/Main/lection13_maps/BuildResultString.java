import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class BuildResultString {
    public static String buildResultString(String[] arr) {
        Map<String, Integer> countMap = new HashMap<>();
        Set<String> resultSet = new LinkedHashSet<>();

        for (String str : arr) {
            countMap.put(str, countMap.getOrDefault(str, 0) + 1);
            if (countMap.get(str) % 2 == 0) {
                resultSet.add(str);
            }
        }

        return resultSet.isEmpty() ? "" : String.join("", resultSet);
    }

    public static void main(String[] args) {
        String[] arr1 = {"a", "b", "a"};
        String[] arr2 = {"a", "b", "a", "c", "a", "d", "a"};
        String[] arr3 = {"a", "", "a"};

        System.out.println(buildResultString(arr1));
        System.out.println(buildResultString(arr2));
        System.out.println(buildResultString(arr3));
    }



}
