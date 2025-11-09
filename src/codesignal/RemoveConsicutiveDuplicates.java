package codesignal;

import java.util.ArrayList;
import java.util.List;

public class RemoveConsicutiveDuplicates {

    public static void main(String[] args) {
        List<String> lst = List.of("a", "A", "B", "C", "C");
        System.out.println(removeConsDups(lst));
    }

    public static List<String> removeConsDups(List<String> inLst) {
        var resultLst = new ArrayList<String>();
        resultLst.add(inLst.getFirst());

        for (int i=1; i< inLst.size(); i++) {
            if(!inLst.get(i).equals(inLst.get(i-1))) {
                resultLst.add(inLst.get(i));
            }
        }
        return resultLst;
    }
}