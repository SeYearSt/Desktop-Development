package rate;

public abstract class Rate{
    double rate;

    public Rate(){
        rate = 0;
    }

    public Rate(double rate){
        this.rate = rate;
    }

    public double getRate(){
        return rate;
    }
}
