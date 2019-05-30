package depositDynamic;

import deposit.Deposit;
import rate.RateQuarter;

public class DepositDynamic extends Deposit{
    private int termQuarters;

    public DepositDynamic(String name, double sum, RateQuarter rate, int termQuarters){
        super(name, sum, rate, termQuarters*3);
        this.termQuarters = termQuarters;
    }

    public double calcProfit(){
        RateQuarter rate = (RateQuarter) this.rate;
        double total = sum;
        for(int i=0; i<termQuarters; ++i){
            total += (1+rate.getRate(i))*total;
        }
        return total;
    }
}
