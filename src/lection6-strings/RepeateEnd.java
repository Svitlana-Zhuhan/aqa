public class RepeateEnd {

    public static String repeatEnd(String str, int n) {
        String lastNChars = str.substring(str.length() -n);
        return lastNChars.repeat(n);
    }
    
    public static void main(String[] args) {
        System.out.println(repeatEnd("Hello", 3));
        System.out.println(repeatEnd("Hello", 2));
        System.out.println(repeatEnd("Hello", 1));
    }
}
