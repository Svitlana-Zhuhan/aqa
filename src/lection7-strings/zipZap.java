public class zipZap {
    public static String zipZap(String str) {
        return str.replaceAll("z.p", "zp");
    }

    public static void main(String[] args) {
        System.out.println(zipZap("zipXzap"));  // "zpXzp"
        System.out.println(zipZap("zopzop"));  // "zpzp"
        System.out.println(zipZap("zzzopzop"));// "zzzpzp"
    }
}
