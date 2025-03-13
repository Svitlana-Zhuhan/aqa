public class DoubleChars {
    public static String doubleChars(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            result.append(c).append(c);
        }
        return result.toString();
    }
    public static void main(String[] args) {
        System.out.println(doubleChars("The"));
        System.out.println(doubleChars("AAbb"));
        System.out.println(doubleChars("Hi-There"));
    }
}
