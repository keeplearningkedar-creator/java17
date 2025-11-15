package codesignal;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class DoAnything {

    public static void main(String[] args) {
       // Passing BiFunction as parameter - function parameterization
       BiFunction<Integer, Integer, String> adder = (n1, n2) -> (n1+n2+"Test");
        System.out.println(addNums(adder));

        ArrayList<String> result = new ArrayList<>();
        result.add("Kedar:5");
        result.stream().mapToInt(i -> Integer.parseInt(i.substring(5,6))).toArray();
        result.stream().map(i -> Integer.parseInt(i.substring(5,6))).filter(i -> i > 3).toList();
    }

    private static String addNums(BiFunction<Integer, Integer, String> adder) {
        return adder.apply(1,2);
    }
}