package codesignal;

public class Anagram {
    public static void main(String[] args) {
        String x = "abcd", y = "cbaz";
        boolean b = isAngram(x, y);
        if (b) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    public static boolean isAngram(String x, String y) {

        if(x.length() != y.length()) return false;

        int[] chars = new int[256];
        for (char c : x.toCharArray()) {
            chars[c]++;
        }

        for (char z : y.toCharArray()) {
            chars[z]--;
            if (chars[z] < 0) {
                return false;
            }
        }
        return true;
    }
}
