package codesignal;

import java.util.*;

public class KMostFrequentNumbers {
    public static void main(String[] args) {
        //int[] ipNumbers = {1,1,1,2,2,2,2,2,4,4,4,4,4,4,4,5,5,0,3,3};
        int[] ipNumbers = {1,1};
        int topKElements = 2;
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        // count frequencies
        for(int num : ipNumbers) {
            freqMap.merge(num, 1, Integer::sum);
        }

        //create buckets of ArrayLists
        List<Integer>[] buckets = new List[ipNumbers.length+1];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        // iterate over freqMap and store-update ArrayList in bucket
        for(int num : freqMap.keySet()) {
                int frequency =  freqMap.get(num);
                buckets[frequency].add(num);
        }

        List<Integer> result = new ArrayList<>();
        //iterate buckets to find topK, and add to result
        for (int i = buckets.length-1; i>=0 && result.size() < topKElements; i--) {
            if (!buckets[i].isEmpty()) {
                for(int aryNUm: buckets[i]) {
                    result.add(aryNUm);
                    if(result.size() == topKElements) break;
                }
            }
        }

        //return - print int[]
        result.forEach(System.out::println);
    }
}
