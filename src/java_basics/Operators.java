package java_basics;

public class Operators {
    public static void main(String[] args) throws Exception {

        int x = 1;
        System.out.println("++x = " + ++x);
        System.out.println("x = " + x);
        x = 1;
        System.out.println("x++ = " + x++);
        System.out.println("x = " + x);

        System.out.println();

        int b = 0;
        int c = 3;
        int result = 0;
        result = ++b - 4 * 3 + c--;

        //post and pre increment and decrement operations should be applied first
        //The next operator in priority is multiplication "*,%,/",
        //then subtraction and addition operators, which we will apply in order from left to right
        //Finally, the assignment operator comes last in the precedence table.

        // result = ((1 - (4 * 3)) + 3); // but  c is 2
        System.out.println("result = " + result); //-8

        int a = 1;
        b = 2;
        c = 3;
        //  || - once the first true statement is found, the latter statements are not evaluated.
        //  && - the first statement is false , latter statements are not evaluated.
        //boolean d = --c < b++ || a == b % c && a++ == 2;
        boolean d = --c < b++ || a == b % c && a++ == 2;
        // d = (2<2)||(1==3%2)&&a++==2 // d= false || true && false // c=2,b=3 || a =2

        //d= false || true && false;
        System.out.println();
        System.out.println("a=" + a);
        System.out.println("b=" + b);
        System.out.println("c=" + c);
        System.out.println("d=" + d);


        x = one() + four() % three() - (two() + one()); //feefumfofifee
        System.out.println(x); //-1

    }

    static int one() {
        System.out.print("fee");
        return 1;
    }

    static int two() {
        System.out.print("fi");
        return 2;
    }

    static int three() {
        System.out.print("fo");
        return 3;
    }

    static int four() {
        System.out.print("fum");
        return 4;
    }
}
