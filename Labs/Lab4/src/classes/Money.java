package classes;

public class Money {
    private long integer;
    private char fraction;

    public Money(){
        this.integer = 0;
        this.fraction = 0;
    }

    public Money(long integer, char fraction) {
        this.integer = integer;
        this.fraction = fraction;
    }

    public Money(Money C){
        this.integer = C.getInteger();
        this.fraction = C.getFraction();
    }

    public long getInteger(){
        return integer;
    }

    public char getFraction(){
        return fraction;
    }

    public void setInteger(long integer){
        this.integer = integer;
    }

    public void setFraction(char fraction){
        this.fraction = fraction;
    }

    Money add(Money B){
        long total = integer * 100 + fraction;
        total += B.getInteger() * 100 + B.getFraction();
        Money C = new Money(total/100, total - total/100);
        return C;

    }
}
