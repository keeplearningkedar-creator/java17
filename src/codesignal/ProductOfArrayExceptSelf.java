package codesignal;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        int[] ary = {1,2,3,4};
        Arrays.stream(product(ary)).forEach(System.out::println);
    }

    private static int[] product(int[] ip) {
        int aryLen = ip.length;
        int[] res = new int[aryLen];
        int[] prefix = new int[aryLen];
        int[] suffix = new int[aryLen];

        prefix[0] = 1;
        for (int i = 1; i < aryLen; i++ )
            prefix[i] = prefix[i-1] * ip[i-1];

        suffix[aryLen-1] = 1;
        for (int i = aryLen-2; i >= 0; i--)
            suffix[i] = suffix[i+1] * ip[i+1];

        for (int i = 0; i < aryLen; i++ )
            res[i] = prefix[i] * suffix[i];

        return res;
    }

}