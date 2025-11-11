package codesignal;

public class Palindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome("abc"));
        System.out.println(isPalindromeWithTwoPointer("aba"));
    }

    public static boolean isPalindrome(String str) {
        for (int i=0; i< str.length()/2; i++ ) {
            if(str.charAt(i) != str.charAt(str.length()-1-i) ) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindromeWithTwoPointer(String str) {
        if(str == null || str.length() < 1) return false;
        if(str != null && str.length() == 1) return true;

        int lp = 0, rp = str.length()-1;
        while(lp < rp) {
            if(str.charAt(lp) == str.charAt(rp)) {
                lp++; rp--;
            } else {
                return false;
            }
        }
        return true;
    }

}
