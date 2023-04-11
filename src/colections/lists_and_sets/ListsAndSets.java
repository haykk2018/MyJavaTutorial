package colections.lists_and_sets;

import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class ListsAndSets {


    public static void main(String[] args) {

        //tree way make immutable list (trying to change it will cause an UnsupportedOperationException exception to be thrown).
        List<String> strList2 = Arrays.asList("Rahul", "Shubham", "Neelam", "Aram");
        List<String> strList3 = List.of("Rahul", "Shubham", "Neelam", "Aram"); // java 9
        List<String> oneElementList = Collections.singletonList("onlyOneElement");
        System.out.println(strList3);

        //strList2.add("newString") and others will give exceptions ;

        //To make a mutable list that is a concrete ArrayList you can create an ArrayList from the immutable list:
        List<String> mutableList1 = new ArrayList<>(List.of("string_one", "string_two"));
        //second mutable way with stream
        List<String> mutableList2 = Stream.of("string_one", "string_two", "string_tree").collect(toList());
        mutableList2.add("string_for");
        mutableList1.add("string_for");
        System.out.println(mutableList1);
        //classic way mutable list
        List<String> strList = new ArrayList<>();
        strList.add("stringOne");
        strList.add("stringTwo");
        System.out.println(strList);

        //all Lists are sortable ArrayLists and LinkedLists, deterrents some functions faster each other


        /* -- SETS -- */

        System.out.println(" -- SETS -- ");
        //immutable set
        Set<String> immutableSet = Set.of("Rahul", "Shubham", "Neelam", "Aram");
        System.out.println(immutableSet);

        //HashSet - Not Sorted, Not ordered.
        Set<String> HSet = new HashSet<>();
        HSet.add("Banana");
        HSet.add("Apple");
        HSet.add("pumpkin");
        System.out.println(HSet);

        // LinkedHashSet - Not Sorted and has adding order
        Set<String> lHSet = new LinkedHashSet<>();
        lHSet.add("Banana");
        lHSet.add("Apple");
        lHSet.add("pumpkin");
        System.out.println(lHSet);

        //TreeSet - Can't be unSorted(if you add not numeric or String object you have to define compilation rule),
        // ordered by sorted condition, impossible other way order unlike lists by index
        Set<String> TSet = new TreeSet<>(Set.of("Banana", "Apple", "pumpkin"));
        //TSet.add(111); exception because string and integer not comparable
        System.out.println(TSet);

        //TreeSet from my crated class objects
        //first way adding comparator from new TreeSet argument
        TreeSet<Good> goodTreeSet = new TreeSet<>(new Comparator<Good>() {
            @Override
            public int compare(Good o1, Good o2) {
                return o1.price - o2.price;
            }
        });
        //Lambda comparator
        //TreeSet<Good> goodTreeSet = new TreeSet<>((o1, o2) -> o1.price- o2.price);
        //Lambda comparator with reference method
        //TreeSet<Good> goodTreeSet = new TreeSet<>(Comparator.comparingInt(Good::getPrice));
        goodTreeSet.add(new Good("pen", 100));
        goodTreeSet.add(new Good("pencil", 90));
        goodTreeSet.forEach(good -> System.out.println(good.name + " - " + good.price));
        // foreach with reference method, println automatically called Overrode String method(ոտնատակ տված)
        goodTreeSet.forEach(System.out::println);

        // this examples by comparator second way when class implement comparable interface        TreeSet<GoodComparable> goodTreeSet2 = new TreeSet<>();
        Set<GoodComparable> goodTreeSet2 = new TreeSet<>();
        goodTreeSet2.add(new GoodComparable("pen", 100));
        goodTreeSet2.add(new GoodComparable("pencil", 90));
        goodTreeSet2.forEach(good -> System.out.println(good.name + " - " + good.price));

    }


}
