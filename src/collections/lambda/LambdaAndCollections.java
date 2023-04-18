package collections.lambda;

import collections.lists_and_sets.Good;

import java.util.*;

public class LambdaAndCollections {

    public static void main(String[] args) {

        List<Good> goods = new ArrayList<>(List.of(new Good("CopyBook", 120), new Good("Pen", 90), new Good("Pencil", 80)));

        List<String> countries = new ArrayList<>(List.of("china", "australia", "germany", "russia", "spain", "south korea"));


        goods.sort((o1, o2) -> o1.getPrice().compareTo(o2.getPrice()));
        System.out.println(goods);


        countries.sort(Comparator.naturalOrder());
        System.out.println();
        System.out.println(countries);

        //reverse
        //countries.sort(Comparator.<String, String>comparing(c -> c).reversed());
        //countries.sort(comparing(Object::toString).reversed());
        countries.sort(Comparator.reverseOrder());
        //goods reverse
        //goods.sort((o1, o2) -> o2.getPrice().compareTo(o1.getPrice()));
        //goods.sort(Comparator.comparing(Good::getPrice).reversed());
        goods.sort(Comparator.comparing(Good::getPrice, Comparator.reverseOrder()));
        System.out.println(goods);

        System.out.println("---replaceALL toUpperCase--");
        countries.replaceAll(String::toUpperCase);

        System.out.println(countries);

        /* Map */


        Map<String, String> phoneBook = new HashMap<>(Map.of("Tom", "00", "Layla", "01", "Michael Butler", "02"));

        phoneBook.replaceAll((name, phone) -> " +374 " + phone + "(" + name + ")"); //replacing all values
        System.out.println("-- replaceAll --");
        phoneBook.forEach((s, s2) -> System.out.println("key:" + s + " value:" + s2));

        Map<String, String> phoneBook2 = new HashMap<>(Map.of("Tom", "00", "Layla", "01", "Michael Butler", "02"));

        /*  compute and merge - Map methods */
        // compute( key, BiFunction )
        System.out.println("-- compute --"); //by map key

        phoneBook2.compute("Layla", (k, v) -> " +374 " + v + "(" + k + ")");
        phoneBook2.forEach((s, s2) -> System.out.println("key:" + s + " value:" + s2));

        System.out.println("-- merge --");
        // merge( key, valIfAbsentKey, BiFunction )

        phoneBook2.merge("Tom", "_MyConcat_", String::concat);
        phoneBook2.forEach((s, s2) -> System.out.println("key:" + s + " value:" + s2));

        System.out.println();
        phoneBook2.merge("T(notExist)", "_MyConcat_", String::concat);
        phoneBook2.forEach((s, s2) -> System.out.println("key:" + s + " value:" + s2));

        System.out.println("--merge with -> String, List<String>--");
        Map<String, List<String>> travelingCountriesMap = new HashMap<>();
        travelingCountriesMap.put("Jon", new ArrayList<>(List.of("Canada", "USA")));
        travelingCountriesMap.put("Aram", new ArrayList<>(List.of("Canada", "USA", "Armenia")));

        travelingCountriesMap.merge("Jon", new ArrayList<>(List.of("USA", "Iran")), (prev, cur) -> {
            prev.addAll(cur);
            return prev;
        });
        travelingCountriesMap.merge("Liza", new ArrayList<>(List.of("USA", "Iran")), (prev, cur) -> {
            prev.addAll(cur);
            return prev;
        });
        travelingCountriesMap.forEach((s, s2) -> System.out.println("key:" + s + " value:" + s2));

        System.out.println("-- compute with -> String, List<String>--");
        travelingCountriesMap.compute("Aram", (k, v) -> {
            if (v != null) {
                v.addAll(new ArrayList<>(List.of("+USA, +Iran")));
                return v;
            }
            return new ArrayList<>(List.of("if_isn't_key", "if_doesn't_exist_key"));
        });
        travelingCountriesMap.forEach((s, s2) -> System.out.println("key:" + s + " value:" + s2));

        System.out.println();
        travelingCountriesMap.compute("Aram1", (k, v) -> {
            if (v != null) {
                v.addAll(new ArrayList<>(List.of("+USA, +Iran")));
                return v;
            }
            return new ArrayList<>(List.of("if_isn't_key", "if_doesn't_exist_key"));
        });

        travelingCountriesMap.forEach((s, s2) -> System.out.println("key:" + s + " value:" + s2));


    }
}
