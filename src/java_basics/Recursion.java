package java_basics;

public class Recursion {
    public static void main(String[] args) {
        // factorial of n, which is n * (n-1) * (n-2) ...
        System.out.println(factorial(4));
        //1, 1, 2, 3, 5, 8, 13, 21, 34, 55,  ...
        System.out.println(fibonacci_Nth(6));
    }

    static int factorial(int n) {
        if (n == 0) return 1;
        return n * factorial(n - 1);
    }

    static int fibonacci_Nth(int nth) {
        if (nth == 0) return 0;
        if (nth == 1) return 1;
        return fibonacci_Nth(nth - 1) + fibonacci_Nth(nth - 2);
    }
}
