public class SumIgnoreSections {

    public static int sumIgnoreSections(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int sum = 0;
        boolean ignore = false;

        for (int num : nums) {
            if (num == 6) {
                ignore = true;
            }

            if (!ignore) {
                sum += num;
            }

            if (ignore && num == 7) {
                ignore = false;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2};
        int[] nums2 = {1, 2, 2, 6, 99, 99, 7};
        int[] nums3 = {1, 1, 6, 7, 2};

        System.out.println("Сума в num1: " + sumIgnoreSections(nums1));
        System.out.println("Сума в num2: " + sumIgnoreSections(nums2));
        System.out.println("Сума в num3: " + sumIgnoreSections(nums3));
    }
}
