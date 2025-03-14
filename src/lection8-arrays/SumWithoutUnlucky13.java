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

        System.out.println("Сума в nums1: " + sumWithoutUnlucky13(nums1));
        System.out.println("Сума в nums2: " + sumWithoutUnlucky13(nums2));
        System.out.println("Сума в nums3: " + sumWithoutUnlucky13(nums3));
    }
}
