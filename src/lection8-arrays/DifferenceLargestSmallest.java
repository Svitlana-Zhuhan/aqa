import java.util.Arrays;

public class DifferenceLargestSmallest {
    public static int differenceLargestSmallest(int[] nums) {
        int min = nums[0];
        int max = nums[0];

        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        return max - min;
    }

    public static void main(String[] args) {
        int[] nums1 = {10, 3, 5, 6};
        int[] nums2 = {7, 2, 10, 9};
        int[] nums3 = {2, 10, 7, 2};

        int[] copy1 = Arrays.copyOf(nums1, nums1.length);
        int[] copy2 = Arrays.copyOf(nums2, nums2.length);
        int[] copy3 = Arrays.copyOf(nums3, nums3.length);

        System.out.println("Сума мін-макс в nums1: " + differenceLargestSmallest(copy1));
        System.out.println("Сума мін-макс в nums2: " + differenceLargestSmallest(copy2));
        System.out.println("Сума мін-макс в nums3: " + differenceLargestSmallest(copy3));
    }
}
