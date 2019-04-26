package classes;

import classes.Money;

public class Bokkeeper {

    public Money add(Money A, Money B){
        long newInteger = A.getInteger() + B.getInteger();
        newInteger += (A.getFraction() + B.getFraction())/100;

        int newFraction = (A.getFraction() + B.getFraction())%100;
        Money C = new Money(newInteger, newFraction);

        return C;

    }

    public Money sub(Money A, Money B){
        long newInteger = A.getInteger() - B.getInteger();

        int newFraction = (A.getFraction() - B.getFraction());
        Money C = new Money(newInteger, newFraction);

        return C;
    }

    public Money div(Money A, float fraction){
        long total = A.getInteger()*100 + A.getFraction();
        total /= fraction;
        long newInteger = (long)(total / 100);
        int newFraction = (int)(total % 100);

        return new Money(newInteger, newFraction);
    }

    public Money mul(Money A, float d){
        long newInteger = (long)(A.getInteger()*d);
        int newFraction = (int)(A.getFraction()*d);
        newInteger += newFraction / 100;
        newFraction = newFraction %100;

        return new Money(newInteger, newFraction);
    }

    public boolean equal(Money A, Money B){
        long totalA = A.getInteger()*100 + A.getFraction();
        long totalB = B.getInteger()*100 + B.getFraction();

        return totalA == totalB;
    }

}
