package codesignal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagram {
    public static void main(String[] args) {

        String[] ipStr = {"abc", "pqr", "cba", "rqp"};
        List<List<String>> grp = getGroupAnngram(ipStr);
        System.out.println(grp);

    }

    public static List<List<String>> getGroupAnngram (String[] ipAry) {
        HashMap<String, List<String>> anaMap = new HashMap<>();

        for (String word : ipAry) {
            char[] sortKey = word.toCharArray();
            Arrays.sort(sortKey);
            String sortStr = new String(sortKey);
            anaMap.putIfAbsent(sortStr, new ArrayList<>());
            anaMap.get(sortStr).add(word);
            //anaMap.put(sortStr, anaMap.get(sortStr));
        }
        return anaMap.values().stream().toList();
    }
}
