package streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {
    public static void main(String[] args) {
        List<String> courses = List.of(
                "Introduction to Java",
                "Kotlin for Java Developers",
                "Spring Framework",
                "Algorithms",
                "Scrum in practice"
        );

        courses.stream()  // obtaining the stream
                .sorted() // an intermediate operation that returns a sorted stream
                .skip(1)  // an intermediate operation
                .limit(3) // an intermediate operation that returns a limited stream
                .forEach(System.out::println); // the final operation that prints each element

        System.out.println();
        List<Integer> numbers = List.of(1, 1, 4, 8, 3, 7, 5, 4, 3); // 9 elements

        long numberOfUniqueElements = numbers.stream() // 1 1 4 8 3 7 5 4 3
                .distinct()
                .peek(System.out::println) // 1 4 8 3 7 5
                .count();

        System.out.println("Result: " + numberOfUniqueElements); // Result: 6

        List<Integer> uniqueNumbers = numbers.stream() // 1 1 4 8 3 7 5 4 3
                .distinct()
                .peek(System.out::println) // 1 4 8 3 7 5
                .collect(Collectors.toList());


        System.out.println("__filter__");
        //As a bonus, we should note that using separating filters instead of using only a single one simplifies the debugging process of a stream because it is possible print intermediate results between these two stages using the peek method.
        numbers.stream()
                .filter(i -> i > 2)
                .filter(i -> i % 4 == 0)
                .forEach(System.out::println);

        System.out.println();
        courses.stream()
                .filter(s -> s.matches(".*(?i)java.*")) //(?i)-case insensitive
                .forEach(System.out::println);

        /* work with ordered
        To avoid that, always use the operations on sorted streams or streams derived from lists or other ordered collections (but not sets).*/
        System.out.println("--takeWhile and dropWhile--");

        Stream.of(10, 13, 11, 7, 0, 5, 8, 11)
                .takeWhile(n -> n > 0)
                .forEach(System.out::println); // 10 13 11 7
        Stream.of(10, 13, 11, 7, 0, 5, 8, 11)
                .dropWhile(n -> n > 0)
                .forEach(System.out::println); // 0 5 8 11

        Stream.of(1, 2, 3, 4, 5).findFirst().get(); // 1
        // Stream.empty().findFirst().get(); // NoSuchElementException
        Stream.empty().findFirst().orElse(0); // 0 because of using the default value
        Stream.of(1, 2, 3, 4, 5).findAny().get(); // most likely it is 1, but no guarantee

        /*
        boolean anyMatch(Predicate<T> predicate) checks whether at least one element of this stream matches the predicate;
        boolean allMatch(Predicate<T> predicate) checks whether all elements of this stream match the predicate;
        boolean noneMatch(predicate<T> predicate)  checks whether no elements of this stream match the predicate.
        */

        //They are terminal
        System.out.println("--Match--");
        Stream.of(1, 8, 4, 11, 12, 3)
                .peek(System.out::println)
                .allMatch(n -> n < 10);

    }
}
