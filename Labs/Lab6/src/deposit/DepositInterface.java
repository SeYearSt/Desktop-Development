package deposit;

import rate.Rate;

public interface DepositInterface {
    public String getName();
    public double getSum();
    public Rate getRate();
    public double getTerm();

    public void setName(String name);
    public void setSum(double sum);
    public void setRate(Rate rate);
    public void setTerm(double term);

}
