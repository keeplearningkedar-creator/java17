package codesignal;

import java.util.*;

class TwoNumberSum {
    public static void main(String[] args) {
        int[] inputArray = {3, 5, -4, 8, 11, 1, -1, 6};
        int[] result = twoNumberSum(inputArray, 10);
        System.out.println("Printing Two Numbers Having Given Sum " + result[0] + "," + result[1]);

        result = twoNumberSumUsingSet(inputArray, 10);
        System.out.println("Using Set - Printing Two Numbers Having Given Sum " + result[0] + "," + result[1]);
    }

    public static int[] twoNumberSum(int[] array, int targetSum) {

        if (array.length == 0) return new int[0];

        HashMap<Integer, Integer> numberIndexMap = new HashMap<>();
        int[] resultArray = new int[2];
        boolean foundMatchingNumbers = false;
        for (int i = 0; i < array.length; i++) {
            int complement = targetSum - array[i];
            if (numberIndexMap.containsKey(complement)) {
                resultArray[0] = array[i];
                int numberIndex = numberIndexMap.get(complement);
                resultArray[1] = array[numberIndex];
                foundMatchingNumbers = true;
                break;
            } else {
                numberIndexMap.put(array[i], i);
            }
        }
        if (!foundMatchingNumbers) return new int[0];

        return resultArray;
    }

    public static int[] twoNumberSumUsingSet(int[] array, int targetSum) {
        HashSet<Integer> numberSet = new HashSet<>();
        for (int num : array) {
            if (numberSet.contains(targetSum - num)) {
                return new int[]{targetSum - num, num};
            } else {
                numberSet.add(num);
            }
        }
        return new int[0];
    }
}

