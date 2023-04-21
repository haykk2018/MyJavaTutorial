package streams;

import collections.lists_and_sets.Good;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Collect_flatMap_map {
    public static void main(String[] args) {

        Set<Integer> numSet = Stream.of(7, 4, 9, 11, 4, 3).collect(Collectors.toSet());

        List<Integer> numbers = new ArrayList<>(List.of(10, 11, 12, 13, 14));

        List<Integer> numbersMultipliedBy2 = numbers.stream()
                //map - transforms a stream of objects into a new stream of other objects
                .map(n -> n * 2)
                .collect(Collectors.toList()); // [20, 22, 24, 26, 28]


        //we can do same by replaceAll but it muted numbers
        numbers.replaceAll(n -> n * 2);        // [20, 22, 24, 26, 28]

        String str = Stream.of("A_B_C", "_D_E").map(x -> x.replace("_", ""))
                .collect(Collectors.joining(" ")); // collect to string
        System.out.println(str);// ABC DE

        //flatmap
        //stream of lists like [[1, 2], [3], [4, 5]], we will get one flatten stream [1, 2, 3, 4, 5]. In other words, the flatMap map transforms a Stream<Stream<T>> to a Stream<T>
        class OnlineCourse {
            private final String title;
            private final List<String> instructors;

            public OnlineCourse(String title, List<String> instructors) {
                this.title = title;
                this.instructors = instructors;
            }

            public List<String> getInstructors() {
                return instructors;
            }
        }
        List<OnlineCourse> courses = List.of(
                new OnlineCourse("Algorithms, Part I", List.of("Kevin Wayne", "Robert Sedgewick")),
                new OnlineCourse("Analysis of Algorithms", List.of("Robert Sedgewick")),
                new OnlineCourse("Programming in Java: A Hands-on Introduction",
                        List.of("Anh Le", "Patrick Ester", "Elise Deitrick"))
        );

        Set<String> instructors = courses.stream()
                .flatMap(course -> course.getInstructors().stream())
                .collect(Collectors.toSet());

        System.out.println("__flatMap__");
        System.out.println(instructors);

        List<List<String>> strings = List.of(
                List.of("j", "a", "v", "a"),
                List.of("i", "s"),
                List.of("g", "r", "e", "a", "t")
        );

        strings.stream()
                .flatMap(Collection::stream)
                .forEach(System.out::println);

        //reduce
        //many elements => single value or object.
        //max, min, count, collect - actually kinds of reduce
        // Optional<T> reduce(BinaryOperator<T> accumulator)
        // T reduce(T identity, BinaryOperator<T> accumulator);

        List<Integer> spendings = List.of(14, 22, 10, 18, 16, 15, 20);

        int total = spendings.stream()
                //partialSum - is accumulating values
                .reduce((partialSum, next) -> partialSum + next)
                // .reduce(Integer::sum)
                .orElse(0);

        //same with identity value
        // int total = spendings.stream().reduce(0, (partialSum, next) -> partialSum + next);

        System.out.println();
        System.out.println(total);

        List<Good> goods = new ArrayList<>(List.of(new Good("CopyBook", 120), new Good("Pen", 90), new Good("Pencil", 80)));
        // reduce instead of operator function - Long reduce(Long identity, BiFunction<Long,Good,Long>, BinaryOperator<Long>)
        int goodsPricesSum = goods.stream()
                .reduce(0, (partial, good) -> partial + good.getPrice(), Integer::sum);
        //or with collect
        long goodsPricesSum2 = goods.stream()
                .collect(Collectors.summingLong(g -> g.getPrice()));
        //alternative variant with map then sum
        long goodsPricesSum3 = goods.stream().mapToLong(Good::getPrice).sum();

        System.out.println();
        System.out.println(goodsPricesSum);
        System.out.println(goodsPricesSum2);

        Map<Boolean, List<Good>> mapWithPartitionedLists = goods.stream().collect(Collectors.partitioningBy(good -> good.getPrice() > 100));

        var mapWithPartitionedLists2 = goods.stream().collect(Collectors.groupingBy(g -> g.getPrice() > 100));

        List<Good> goods3 = new ArrayList<>(List.of(new Good("CopyBook", 120, "books"), new Good("Pen", 90, "accessories"),
                new Good("Pencil", 80, "accessories"), new Good("Pencil", 55, "accessories")));

        var mapWithPartitionedLists3 = goods3.stream().collect(Collectors.groupingBy(Good::getCategory));

        var mapWithPartitionedLists4 = Stream.of("php", "groovy", "java").collect(Collectors.groupingBy(String::length));

        var mapWithPartitionedLists5 = goods3.stream().collect(Collectors.groupingBy(Good::getCategory, Collectors.summingLong(Good::getPrice)));

        var mapWithPartitionedLists6 = goods3.stream().collect(Collectors.groupingBy(Good::getCategory, Collectors.filtering(g -> g.getPrice() > 10, Collectors.summingInt(g -> 1))));


        System.out.println(mapWithPartitionedLists);
        System.out.println(mapWithPartitionedLists2);
        System.out.println(mapWithPartitionedLists3);
        System.out.println(mapWithPartitionedLists4);
        System.out.println(mapWithPartitionedLists5);
        System.out.println("groupingBy and filtering");
        System.out.println(mapWithPartitionedLists6);
        Map<String, List<Good>> groupOfGoodlist = new HashMap<>();
        groupOfGoodlist.put("gr1", goods3);
        groupOfGoodlist.put("group2", List.of(new Good("noteBook", 120, "books"), new Good("Pen", 90), new Good("Pen", 55)));
        groupOfGoodlist.put("group1", List.of(new Good("noteBook", 120, "books")));

        var listFromMapKeys = groupOfGoodlist.entrySet().stream().map(e -> e.getKey()).toList();
        var mapWithPartitionedLists7 = groupOfGoodlist.entrySet().stream()
                .collect(Collectors.groupingBy(Map.Entry::getKey, Collectors.filtering(m -> m.getValue().stream().anyMatch(g -> g.getName() == "Pen"), Collectors.counting())));
        System.out.println();
        System.out.println(listFromMapKeys);
        System.out.println(mapWithPartitionedLists7);


    }


}
