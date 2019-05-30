package depositStatic;

import rate.Rate;
import deposit.Deposit;

public class DepositStatic extends Deposit{
    private double monthRate;

    public DepositStatic(String name, double sum, Rate rate, double term){
        super(name, sum, rate, term);
        monthRate = rate.getRate()/12;
    }

    public double calcProfit(){
        return (1+monthRate*term)*sum;
    }
}
