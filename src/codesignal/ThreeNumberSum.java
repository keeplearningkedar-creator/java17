package codesignal;

import java.util.*;

class ThreeNumberSum {

    public static void main(String[] args) {
        Integer[] in = new Integer[] {5,4,3,8,-3,-1};
        List<Integer[]> result = threeNumberSum(in, 10);
        for (Integer[] row : result) {
            System.out.println(row[0] + ":" +row[1]+ ":"+ row[2]);
        }
    }

    public static List<Integer[]> threeNumberSum(Integer[] array, int targetSum) {

        List<Integer[]> resultList = new ArrayList<Integer[]>();
        if(array.length < 3) return resultList;

        int cn = 0;
        Arrays.sort(array);
        for(int ipAryIndex = 0; ipAryIndex < array.length; ipAryIndex++) {
            cn = array[ipAryIndex];
            int lp = ipAryIndex+ 1, rp = array.length-1;

            while(lp < rp) {
                int interimSum = cn + array[lp] + array[rp];
                if(interimSum == targetSum) {
                    resultList.add(new Integer[] {cn, array[lp], array[rp]});
                    lp++; rp--;
                } else if (interimSum < targetSum) {
                    lp++;
                } else {
                    rp--;
                }
            }
        }
        return resultList;
    }
}

