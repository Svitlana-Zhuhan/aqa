import java.util.HashMap;
import java.util.Map;

public class MostFrequentElement {
    public static int findMostFrequentElement(int[] arr) {
        Map<Integer,Integer> countMap = new HashMap<>();
        int maxCount = 0;
        int mostFrequent = arr[0];

        for (int num : arr) {
            countMap.put(num,countMap.getOrDefault(num,0) + 1);
            if (countMap.get(num) > maxCount) {
                maxCount = countMap.get(num);
                mostFrequent = num;
            }
        }

        return mostFrequent;
    }

    public static void main(String[] args) {


        System.out.println(findMostFrequentElement(new int[]{3, 1, 2, 2, 1, 2, 3, 3, 3}));
        System.out.println(findMostFrequentElement(new int[]{5, 5, 5, 5, 4, 2, 2, 2, 1, 2, 1, 2}));
    }
}
