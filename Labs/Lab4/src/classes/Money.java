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
        long newInteger = this.integer + B.getInteger() + (this.fraction + B.getFraction())/100;
        char newFraction = (char)((this.fraction + B.getFraction())%100);
        Money C = new Money(newInteger, newFraction);
        return C;

    }
}
