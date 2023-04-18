package collections.maps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Maps {
    public static void main(String[] args) {

        //HashMap will print sorted values too but there is no guarantee of maintaining that order.
        //TreeMap maintaining sorted order (natural)
        Map<Integer, String> customers = new TreeMap<>();

        customers.put(2, "Smith");
        customers.put(3, "Sally");
        customers.put(4, "Aram");
        customers.put(1, "Jon");
        System.out.println("--TreeMap--");
        customers.forEach((id, val) -> System.out.println("Key : " + id + " value : " + val));

        //LinkedHashMap maintaining insertion order
        Map linkedHM = new LinkedHashMap();
        linkedHM.put(2, "Smith");
        linkedHM.put(3, "Sally");
        linkedHM.put(4, "Aram");
        linkedHM.put(1, "Jon");
        System.out.println("--LinkedHashMap--");
        linkedHM.forEach((id, val) -> System.out.println("Key : " + id + " value : " + val));

    }
}
