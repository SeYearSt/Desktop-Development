package deposit;

import rate.Rate;

public abstract class Deposit implements DepositInterfaceAdvanced{
    protected String name;
    protected double sum;
    protected Rate rate;
    protected double term;

    protected Deposit(String name, double sum, Rate rate, double term){
        this.name = name;
        this.sum = sum;
        this.rate = rate;
        this.term = term;
    }
    public String getName(){
        return name;
    }
    public double getSum(){
        return sum;
    }
    public Rate getRate(){
        return rate;
    }
    public double getTerm(){
        return term;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setSum(double sum){
        this.sum = sum;
    }
    public void setRate(Rate rate){
        this.rate = rate;
    }
    public void setTerm(double term){
        this.term = term;
    }
}
