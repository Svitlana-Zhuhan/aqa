import java.util.Arrays;

public class CenteredAverage {
    public static int centeredAverage(int[] nums){
        Arrays.sort(nums);

        int sum = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            sum += nums[i];
        }
        return sum / (nums.length - 2);
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 100};
        int[] nums2 = {1, 1, 5, 5, 10, 8, 7};
        int[] nums3 = {-10, -4, -2, -4, -2, 0};

        System.out.println("Середнє значення в nums1: " + centeredAverage(nums1));
        System.out.println("Середнє значення в nums2: " + centeredAverage(nums2));
        System.out.println("Середнє значення в nums3: " + centeredAverage(nums3));
    }
}
