package classes;

import classes.Bokkeeper;

public class Money {
    private long integer;
    private int fraction;
    private Bokkeeper counter;

    public Money() {
        this.integer = 0;
        this.fraction = 0;
        this.counter = new Bokkeeper();
    }

    public Money(long integer, int fraction) {
        this.integer = integer;
        this.fraction = fraction;
        this.counter = new Bokkeeper();
    }

    public Money(Money C) {
        this.integer = C.getInteger();
        this.fraction = C.getFraction();
        this.counter = new Bokkeeper();
    }

    public long getInteger() {
        return integer;
    }

    public int getFraction() {
        return fraction;
    }

    public void setInteger(int integer) {
        this.integer = integer;
    }

    public void setFraction(int fraction) {
        this.fraction = fraction;
    }

    public Money add(Money B) {
        return counter.add(this, B);
    }

    public Money sub(Money B) {

        return counter.sub(this, B);
    }

    public Money div(float fraction){
        return counter.div(this, fraction);
    }

    public Money mul(float d){
        return counter.mul(this, d);
    }

    public boolean equal(Money B){
        return counter.equal(this, B);
    }

    @Override
    public String toString() {
        return String.format("%s,%s hrn", integer, fraction);
    }
}
