public class XYZMiddle {

    public static boolean xyzMiddle(String str) {
        if (str == null || str.length() < 3) {
            return false;
        }

        for (int i = 0; i <= str.length() - 3; i++) {
            if (str.substring(i, i + 3).equals("xyz")) {
                int left = i;
                int right = str.length() - (i + 3);
                if (Math.abs(left - right) <= 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(xyzMiddle("AAxyzBB"));
        System.out.println(xyzMiddle("AxyzBB"));
        System.out.println(xyzMiddle("AxyzBBB"));

    }
}


