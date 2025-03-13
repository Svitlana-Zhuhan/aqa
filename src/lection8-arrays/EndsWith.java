public class EndsWith {
    public static boolean endsWith(String a, String b) {
        if (a == null || b == null) {
            return false;
        }

        a = a.toLowerCase();
        b = b.toLowerCase();

        if (a.endsWith(b) || b.endsWith(a)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(endsWith("AbC", "HiaBc"));
        System.out.println(endsWith("abc", "abXabc"));
        System.out.println(endsWith("Hiabc", "abc"));
    }
}
