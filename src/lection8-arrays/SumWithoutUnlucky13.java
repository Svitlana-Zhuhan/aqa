import java.util.Arrays;

public class SumWithoutUnlucky13 {
    public static int sumWithoutUnlucky13(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int sum = 0;
        boolean ignore = false;

        for (int num : nums) {
            if (num == 13) {
                ignore = true;
            }

            if (!ignore) {
                sum += num;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {1, 1};
        int[] nums3 = {1, 2, 2, 1, 13};

        int[] copy1 = Arrays.copyOf(nums1, nums1.length);
        int[] copy2 = Arrays.copyOf(nums2, nums2.length);
        int[] copy3 = Arrays.copyOf(nums3, nums3.length);

        System.out.println("Сума в nums1: " + sumWithoutUnlucky13(copy1));
        System.out.println("Сума в nums2: " + sumWithoutUnlucky13(copy2));
        System.out.println("Сума в nums3: " + sumWithoutUnlucky13(copy3));
    }
}
