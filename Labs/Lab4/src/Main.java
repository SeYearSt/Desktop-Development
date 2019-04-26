import classes.Fraction;
import classes.Money;

public class Main {
    public static void main(String [] args){
        float fraction = 3;
        float d = 4;
        Money A = new Money(10, 50);
        Money B = new Money(20, 40);
        System.out.print("A=");
        System.out.println(A);
        System.out.print("B=");
        System.out.println(B);
        System.out.print("A+B=");
        System.out.println(A.add(B));
        System.out.print("A-B=");
        System.out.println(A.sub(B));
        System.out.print("A/B=");
        System.out.println(A.div(fraction));
        System.out.print("A*B=");
        System.out.println(A.mul(fraction));
        System.out.print("A==B=");
        System.out.println(A.equal(B));


    }
}
