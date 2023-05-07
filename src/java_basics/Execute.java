package java_basics;


import java.util.List;
import java.util.stream.Collectors;

class Execute {
    public static void main(String[] args) {

        List<Integer> list = List.of(1, 2, 3, 4);
        int total = 0;
        for (Integer l : list) {
            if (l % 2 == 0)
                total += l * l;
        }
        System.out.println(total);

        total = list.stream().filter(l -> l % 2 == 0).mapToInt(l -> l * l).sum();

        System.out.println(total);

        total = list.stream().mapToInt(l -> {
            if (l % 2 == 0) return l * l;
            return 0;
        }).sum();

        System.out.println(total);

        total = list.stream().filter(l -> l % 2 == 0).reduce(0, (integer, integer2) -> integer + integer2 * integer2);

        System.out.println(total);


    }
}