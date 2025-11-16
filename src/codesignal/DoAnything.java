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
        //result.stream().mapToInt(i -> Integer.parseInt(i.substring(5,6))).toArray();
        //result.stream().map(i -> Integer.parseInt(i.substring(5,6))).filter(i -> i > 3).toList();

        printCityORCountyName(new County(10101, "Cook"));
    }

    private static String addNums(BiFunction<Integer, Integer, String> adder) {
        return adder.apply(1,2);
    }

    private static void printCityORCountyName(Object cityOrCounty) {
        switch(cityOrCounty) { //PatternMatching for record
            case County c -> System.out.println("County Zip Code:"+c.zipCode());
            case City(int population, String ctName) -> System.out.println("City Population:"+ctName); // Decounstruction
            default -> System.out.println("Not a City or County");
        }
    }
}

record County (int zipCode, String countName){};
record City (int polulation, String cityName) {};