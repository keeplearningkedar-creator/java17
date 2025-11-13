package codesignal;

import java.util.ArrayList;
import java.util.List;

public class IsValidArraySubsequence {

    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<>();
        array.add(1); array.add(2); array.add(3); array.add(4);

        ArrayList<Integer> sequence = new ArrayList<>();
        array.add(1); array.add(2);

        System.out.println(isValidSubsequence(array, sequence));
    }

    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        // Write your code here.
        int aryPtr = 0, seqPtr = 0;

        while (aryPtr < array.size() && seqPtr < sequence.size()) {
            if (array.get(aryPtr) == sequence.get(seqPtr)) {
                seqPtr++;
            }
            aryPtr++;
        }
        return seqPtr == sequence.size();
    }
}
