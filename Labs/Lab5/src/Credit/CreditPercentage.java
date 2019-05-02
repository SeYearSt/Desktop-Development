package Credit;

import Credit.Credit;

public class CreditPercentage extends Credit{
    private double residualPrecent = 0.4;
    private int lastMonth = paymentSchedule.length-1;

    private void checkPayment(double paymentSum){
        if (paymentSum <= 0){
            throw new IllegalArgumentException("Payment can't be negative.");
        }
    }

    public CreditPercentage(long sum, int dateTake, int dateGive){
        super(sum, dateTake, dateGive);
    }

    public void pay(double paySum, int month){
        checkDate(month);

        if (month == lastMonth && paySum < paymentSchedule[lastMonth]){
            throw new IllegalArgumentException("You can't pay less than you must, because it`s the last month");
        }

        if (month < lastMonth){
            double residual = paymentSchedule[month] - paySum;
            paymentSchedule[month+1] += (1+residualPrecent)*residual;
            paymentHistory[month] = paySum;
        }

        paymentSchedule[month] = 0;

    }
}
