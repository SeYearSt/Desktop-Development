import complex.Complex;

public class Main {
    public static void main(String [] args){
        Complex A = new Complex(1, 2);
        Complex B = new Complex(2, 2);

        System.out.println(A.add(B));
        System.out.println(A.sub(B));
        System.out.println(A.mul(B));
        System.out.println(A.div(B));
        System.out.println(A.equ(B));

    }

}
