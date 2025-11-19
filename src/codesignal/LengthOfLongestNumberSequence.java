package codesignal;

import java.util.HashSet;

public class LengthOfLongestNumberSequence {

    public static void main(String[] args) {
        int[] ip = new int[]{8,3,1,7,88,34,33,29,9,6,8,10};

        //Arrays.Sort is obvious option but that is O(n log n) - meaning time to sort increases as number of input elements increase

        // Take Left neighbor option for O(n) solution
        HashSet<Integer> numberSet = new HashSet<>();
        for (int i = 0; i < ip.length; i++) {
            numberSet.add(ip[i]);
        }

        int longest = 0;
        for (int i = 0; i < ip.length; i++) {
            int length = 0;
            if(!numberSet.contains(ip[i]-1)) {
                while(numberSet.contains(ip[i]+length)) {
                    length++;
                }
            }
            longest = Math.max(length, longest);
        }
        System.out.println("Longest Sequence of numbers is of length:"+longest);
    }
}
