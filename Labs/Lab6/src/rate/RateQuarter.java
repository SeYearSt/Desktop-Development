package rate;

public class RateQuarter extends Rate {
    private double[] rate;

    public RateQuarter(double[] rate){
        this.rate = rate;
    }

    public double getRate(int quater){
        return this.rate[quater];
    }

    public String toString(){
        return String.format("1: %.2f, 2: %.2f, 3: %.2f, 4: %.2f", rate[0], rate[1], rate[2], rate[3]);
    }
}
