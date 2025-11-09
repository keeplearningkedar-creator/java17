package base;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamInterviewProgramming {
    public static void main(String[] args) {

        /*Print me top 3, most frequently occuring numbers*/
     List<Integer> ints  = List.of(1,4,7,3,3,3,7,2,7,0,3,5,7,4);
      ints.stream()
              .collect(Collectors.groupingBy(n->n, Collectors.counting()))
              .entrySet()
              .stream()
              .sorted((e1,e2)-> e2.getValue().compareTo(e1.getValue()))
              .limit(2);
             // .forEach(e ->System.out.println("Key is "+e.getKey()+"Value is "+e.getValue()));

      /*Find me 2nd most frequent occuring number from a list*/
        List<Integer> intLst = List.of(5,5,5,3,3,3,4,4,4,4);
        intLst.stream()
                .collect(Collectors.groupingBy(n->n, Collectors.counting()))
                .entrySet().stream().sorted((e1,e2)->e1.getValue().compareTo(e2.getValue()))
                .skip(1).findFirst();
                //.ifPresent(s-> System.out.println("2nd Most"+s));


        /* Merge 2 lists into 1 using flatmap*/
        List<Integer> list1 = List.of(1, 2, 3);
        List<Integer> list2 = List.of(4, 5, 6);

        Stream.of(list1, list2)
                        .flatMap(Collection::stream)
                                .toList();
                //.forEach(System.out::println);

        /* Give me common element from the list*/
        List<Integer> list3 = List.of(1,2,3);
        List<Integer> list4 = List.of(3,4,5,2);

        list3.stream()
                .filter(list4::contains);
                //.forEach(System.out::println);

        /* Give me a map having string lenght as value */
        List<String> strings = List.of("apple", "banana", "cherry");
        strings.stream()
                .collect(Collectors.toMap(s->s, s -> s.length()))
                .entrySet();
                //.forEach(e-> System.out.println(""+e.getValue()+"   "+e.getKey()));


        // Question 6: Calculate the sum, product, min and max of all integers in a list
        List<Integer> nums = List.of(1, 2, 3, 4);
        // reduce() is used when we want to combine all elements of a stream into a single value (e.g., sum,
        // product, minimum, maximum, concatenation).
        // The first argument is the identity value (1 for multiplication, 0 for sum); which acts as initial value for said operation

        Optional<Integer> sum = nums.stream()
                .reduce(Integer::sum);//ideally for sum identity value will be zero
        //sum.ifPresent(System.out::println);

        Integer sumV = nums.stream().reduce(0, Integer::sum);
        //System.out.println("sum val"+sumV);

        Integer mult = nums.stream().reduce(1, (a,b)-> a*b);
        //System.out.println("mult  "+mult);
        Integer max = nums.stream().reduce(Integer::max).orElse(0);

        List<String> givenWords = List.of("Java", "Streams", "are", "powerful");
        givenWords.stream().reduce("", String::concat);
        //System.out.println(givenWords.stream().reduce("", (a, b) -> a + b));

        // Question 7: Filter out non-prime numbers using streams
        List<Integer> numList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> collect1 = numList.stream()
                // we are excluding 1 because 1 is neither prime nor composite. No need to check divisors beyond sqrt(n)
                // because if n has a factor greater than sqrt(n), it must also have one smaller than sqrt(n).
                // Ensures no number in the range divides n evenly. if none divides n, then n is prime.
                .filter(n -> n > 1 && IntStream.rangeClosed(2, (int) Math.sqrt(n)).noneMatch(i -> n % i == 0))
                .collect((Collectors.toList()));
        //System.out.println(collect1);

      // Question 8: Partition strings by length: short (<5), medium (5-10), long (>10)
        List<String> words = List.of("apple", "banana", "cherry", "date", "fig", "grapefruit", "kiwi", "sfrrrrretertttr");
        Map<String, List<String>> catByLen = words.stream().collect(Collectors.groupingBy(word -> {
          if(word.length() < 5) return "short";
          else if (word.length() <=10) return "medium";
          else return "long";
        }));
      //System.out.println(catByLen);

      // Question 9: Find repeating characters in a string
      String input = "programming";
      List<Character> charList = input.chars().mapToObj(c -> (char) c)
              .collect(Collectors.groupingBy(c->c, Collectors.counting()))
              .entrySet().stream()
              .filter(e -> e.getValue() > 1)
              .map( e->e.getKey())
              .collect(Collectors.toList());
      System.out.println(charList);































    }
}
