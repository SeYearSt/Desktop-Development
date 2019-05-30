package rate;

public class RateYear extends Rate {

    public RateYear(double rate){
        super(rate);
    }

    public String toString(){
        return String.format("%.2f", rate);
    }
}
