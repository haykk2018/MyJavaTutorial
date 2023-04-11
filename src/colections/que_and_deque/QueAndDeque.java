package colections.que_and_deque;

import java.util.*;

public class QueAndDeque {

    public static void main(String[] args) {
        //Que FIFO
        //also we can use classes below
        //Queue queue = new ArrayDeque();
        //Queue queue = new PriorityQueue();
        Queue queue = new LinkedList();
        queue.add("first");
        queue.offer("second");

        System.out.println("--queue--");
        queue.forEach(System.out::println);

        //Deque FIFO + LIFO
        //Deque deque = new LinkedList();
        Deque deque = new ArrayDeque<>();
        deque.add("first");
        deque.push("second");

        System.out.println("--deque--");
        deque.forEach(System.out::println);

    }
}
