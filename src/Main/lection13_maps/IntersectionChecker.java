import java.util.Arrays;
import java.util.LinkedHashSet;

public class IntersectionChecker {
    public static boolean hasIntersection(LinkedHashSet<Integer> setA, LinkedHashSet<Integer> setB) {
        LinkedHashSet<Integer> inersection = new LinkedHashSet<>(setA);

        for (Integer num : setA) {
            if (setB.contains(num)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LinkedHashSet<Integer> setA = new LinkedHashSet<>(Arrays.asList(1, 2, 3, 4));
        LinkedHashSet<Integer> setB = new LinkedHashSet<>(Arrays.asList(3, 5, 6));

        System.out.println(hasIntersection(setA,setB));
    }
}
