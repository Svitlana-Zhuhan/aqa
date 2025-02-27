public class Xyz {
    public static boolean xyzThere(String str) {
        // Перебираємо всі можливі входження "xyz"
        for (int i = 0; i <= str.length() - 3; i++) {
            if (str.substring(i, i + 3).equals("xyz")) {
                if (i == 0 || str.charAt(i - 1) != '.') {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(xyzThere("abcxyz"));
        System.out.println(xyzThere("abc.xyz"));
        System.out.println(xyzThere("xyz.abc"));
    }
}
