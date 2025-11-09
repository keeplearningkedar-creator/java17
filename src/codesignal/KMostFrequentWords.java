package codesignal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KMostFrequentWords {

    public static void main(String[] args) {
        String[] ip = {"apple","banana","apple","pear","banana","apple", "peach", "peach", "peach"};
        System.out.println(topKFrequentWords(ip, 2));
    }

    private  static List<String> topKFrequentWords(String[] ip, int k) {
        if (ip.length < 0) return List.of();
        var freqMap = new HashMap<String, Integer>();

        for (String ipVal : ip)
            freqMap.merge(ipVal, 1, Integer::sum);

        return freqMap.entrySet().stream().sorted((a,b) -> {
                            int freqComp = b.getValue().compareTo(a.getValue());
                            return freqComp != 0 ? freqComp : a.getKey().compareTo(b.getKey());
                        }
                )
                .limit(k)
                .map(Map.Entry::getKey)
                .toList();
    }
}
