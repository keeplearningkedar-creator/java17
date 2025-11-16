package codesignal;

import java.util.*;

public class EncodeDecodeStringWithLengthNDelimiter {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        //Collections.addAll(strings, "Test1", "Problem2", "Solution3");
        //    List<String> sourceString = List.of("Test1", "Problem2", "Solution3");
        //    strings.addAll(sourceString);
        strings.addAll(Arrays.asList("Test1", "Problem2", "Solution3"));
        String encodedString = encode(strings);
        System.out.println("Decoded:"+decode(encodedString));
    }

    private static List<String> decode(String encodedString) {
        // find delimiter
        List<String> returnList = new ArrayList<>();
        int i=0;
        while (i < encodedString.length()) {
            int j = i;
            while( j < encodedString.length() && encodedString.charAt(j) != '#') {
                j++;
            }
            //find word
            int wordLength = Integer.parseInt(encodedString.substring(i,j));
            j++;
            String word = encodedString.substring(j,j+wordLength);
            returnList.add(word);
            i  = j+wordLength;
        }
        return returnList;
    }

    private static String encode(ArrayList<String> strings) {
        StringBuffer stbf = new StringBuffer();
        strings.forEach( ip -> {stbf.append(ip.length()); stbf.append("#");  stbf.append(ip);});
        String encodedString = stbf.toString();
        System.out.println("Encoded:"+encodedString);
        return encodedString;
    }

}
