package colections.iteration;

import java.util.*;

public class Main1 {

    public static void main(String[] args) {

        Set<String> set = new HashSet(Set.of("Jon", "Smith", "sally"));

        System.out.println("--classic loop way--");
        for (String s : set) {
            System.out.println(s);
        }
        System.out.println("--with foreach--");
        set.forEach(System.out::println);

        System.out.println("--with stream and foreach--");
        set.stream().forEach(System.out::println);

        System.out.println("-- remove variant with removeIf --");

        Set<Book> booksSet = new HashSet<>(Set.of(new Book("Byron", 15), new Book("Hugo", 16), new Book("Teryan", 20)));
        booksSet.removeIf(s -> Objects.equals(s.author, "Hugo"));
        for (Object book : booksSet) {
            System.out.println(book);
        }

        System.out.println("-- remove variant with iterator --");

        Iterator<Book> iterItems = booksSet.iterator();
        while (iterItems.hasNext()){
            // next() method  by turn returns element of collection, if we call it again will return second element
            if(Objects.equals(iterItems.next().author, "Byron"))
                iterItems.remove();
        }
        booksSet.forEach(System.out::println);

        Map<Integer, String> customers = new HashMap<>();
        customers.put(1, "Jon");
        customers.put(2, "Smith");
        customers.put(3, "Sally");

        System.out.println("Using foreach in Java 8");
        customers.forEach((id, name) -> System.out.println("Key : " + id + " value : " + name));

        System.out.println("stream");
        customers.entrySet().stream().forEach(e ->
                System.out.println("Key : " + e.getKey() + " value : " + e.getValue())
        );

        System.out.println("Using entrySet()");
        for (Map.Entry<Integer, String> entry : customers.entrySet()) {
            System.out.println("Key : " + entry.getKey() + " value : " + entry.getValue());
        }

        System.out.println("Using entrySet() with var");
        for (var entry : customers.entrySet()) {
            System.out.println("Key : " + entry.getKey() + " value : " + entry.getValue());
        }

        //not so effective you are doing extra get(key)
        System.out.println("Using keySet() not so effective");
        for (Integer key : customers.keySet()) {
            System.out.println("Key : " + key + " value : " + customers.get(key));
        }

        System.out.println("Using iterator");
        Iterator<Map.Entry<Integer, String>> iterator = customers.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            System.out.println("Key : " + entry.getKey() + " value : " + entry.getValue());
        }


        System.out.println("Using iterator by keySet");
        Iterator<Integer> iteratorByKeySet = customers.keySet().iterator();
        while (iteratorByKeySet.hasNext()) {
            Integer key = iteratorByKeySet.next();
            System.out.println("Key : " + key + " value : " + customers.get(key));
        }

        System.out.println("-- Map remove with removeIf --");
        //customers.entrySet().removeIf(entry -> entry.getValue().equals("Smith") );
        customers.values().removeIf(val -> val.equals("Smith") );

        customers.forEach((id, name) -> System.out.println("Key : " + id + " value : " + name));
    }
}
