package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Collect_flatMap_map {
    public static void main(String[] args) {

        Set<Integer> numSet = Stream.of(7, 4, 9, 11, 4, 3).collect(Collectors.toSet());

        List<Integer> numbers = new ArrayList<>(List.of(10, 11, 12, 13, 14));

        List<Integer> numbersMultipliedBy2 = numbers.stream()
                .map(n -> n * 2)
                .collect(Collectors.toList()); // [20, 22, 24, 26, 28]


        //we can do same by replaceAll but it muted numbers
        numbers.replaceAll(n -> n * 2);        // [20, 22, 24, 26, 28]

        String str = Stream.of("A_B_C", "_D_E").map(x -> x.replace("_", ""))
                .collect(Collectors.joining(" ")); // collect to string
        System.out.println(str);// ABC DE
    }

}
