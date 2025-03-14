public class EvenIntsCounter {

    public static int countEvenInts(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (num % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 1, 2, 3, 4};
        int[] nums2 = {2, 2, 0};
        int[] nums3 = {1, 3, 5};

        System.out.println("Кількість парних чисел в nums1: " + countEvenInts(nums1));
        System.out.println("Кількість парних чисел в nums2: " + countEvenInts(nums2));
        System.out.println("Кількість парних чисел в nums3: " + countEvenInts(nums3));
    }
}
