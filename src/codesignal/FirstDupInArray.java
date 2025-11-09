package codesignal;

import java.util.HashSet;

public class FirstDupInArray {
    public static void main(String[] args) {
        int[] ints = {1,2,3,2,1};
        var intSet = new HashSet<Integer>();
        for(Integer in : ints) {
            if(!intSet.add(in)) {
                System.out.println("First Dup:"+in);
                break;
            }
        }
    }
}
