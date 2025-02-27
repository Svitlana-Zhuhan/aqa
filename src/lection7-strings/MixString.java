public class MixString {
    public static String mixString(String a, String b) {
        int minLength = Math.min(a.length(), b.length());

        String result = "";
        for (int i = 0; i < minLength; i++) {
            result += a.charAt(i);
            result += b.charAt(i);
        }
        result += a.substring(minLength);
        result += b.substring(minLength);

        return result;
    }

    public static void main(String[] args) {
        System.out.println(mixString("abc", "xyz"));
        System.out.println(mixString("Hi", "There"));
        System.out.println(mixString("xxxx", "There"));
    }

}
