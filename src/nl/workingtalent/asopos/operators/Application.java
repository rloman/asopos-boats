package nl.workingtalent.asopos.operators;

public class Application {

    public static void main(String[] args) {

        int a = 3;

        int b = 4;

        int c = a + b;

        int d = a / b;

        int e = a * b;

        // postfix increment
        e++;

        // prefix increment
        ++e;

        // first print and than increment by 1
        System.out.println(e++);

        // first increment and than print
        System.out.println(++e);

        System.out.println(e);
        e++;


        // mod

        double divide = 13.0/4;
        int remainder = 13 % 4;

        System.out.println(divide);

        System.out.println(divide != 3);
        System.out.println(remainder == 1);

        if(divide > 13 != remainder < 10) {

        }

        int r = 5 & 3;

        System.out.println(r);

        r = 5 | 3;

        System.out.println(r);

        r +=3; // is gelijk aan: r = r +3;
        r *=3; // is gelijk aan: r = r *3;


    }
}
