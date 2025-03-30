import java.util.Arrays;
import java.util.TreeSet;

public class TreeSetMerger {
    public static TreeSet<Integer> mergeTreeSets(TreeSet<Integer> setA, TreeSet<Integer> setB) {
        TreeSet<Integer> mergedSet = new TreeSet<>();
        mergedSet.addAll(setA);
        mergedSet.addAll(setB);

        return mergedSet;
    }

    public static void main(String[] args) {
        TreeSet<Integer> setA = new TreeSet<>(Arrays.asList(1, 2, 3));
        TreeSet<Integer> setB = new TreeSet<>(Arrays.asList(3, 4, 5));

        System.out.println(mergeTreeSets(setA, setB));
    }
}
