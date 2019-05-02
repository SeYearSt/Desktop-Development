package Credit;

import java.util.Arrays;

public class Credit {
    protected long sum;
    protected int dateTake, dateGive, duration;
    protected double [] paymentHistory;
    protected double [] paymentSchedule;
    protected double sumInterestRate;

    protected static long minSum = 10000;
//    protected static double firstPaymentPart = 0.3;
    protected static int minDuration = 6;
    protected static double interestRate = 0.2;
    protected static int firstMonth = 0;
    protected static int lastMonth = 11;


    void initPaymentSchedule(){
        double firstPaymentPart = 0.3;

        paymentSchedule = new double[duration];

        paymentSchedule[0] = sumInterestRate*firstPaymentPart;
        double otherPaymentPart = sumInterestRate*(1 - firstPaymentPart)/(duration-1);

        for (int i=1; i<duration; ++i){
            paymentSchedule[i] = otherPaymentPart;
        }
    }

    void checkDate(int date){
        if (date < Credit.firstMonth || date > Credit.lastMonth ){
            throw new IllegalArgumentException(String.format("date cannot be less than %d or more than %d",
                    Credit.firstMonth, Credit.lastMonth));
        }
    }

    void checkSum(double sum){
        if (sum <= 0 || sum < Credit.minSum){
            throw new IllegalArgumentException(String.format("Sum cannot be less than zero " +
                    "or then minimal sum = %d", Credit.minSum));
        }
    }

    public Credit(long sum, int dateTake, int dateGive){
        checkSum(sum);
        checkDate(dateTake);
        checkDate(dateGive);

        int duration = dateGive - dateTake;
        if (duration < Credit.minDuration){
            throw new IllegalArgumentException(String.format("duration cannot be less than %d", Credit.minDuration));
        }

        this.sum = sum;
        this.sumInterestRate = sum + sum*Credit.interestRate;
        this.duration = duration;
        this.dateTake = dateTake;
        this.dateGive = dateGive;

        initPaymentSchedule();
        paymentHistory = new double [duration];
    }

    public double getPaymentScheduleMonth(int month){
        checkDate(month);

        if (month >= 0 && month <= paymentSchedule.length){
            return paymentSchedule[month];
        }

        throw new ArrayIndexOutOfBoundsException("month out of paymentSchedule's bounds");
    }

    public double getTotalPaid(int month){
        checkDate(month);

        double totalPaid = 0;
        if (month >= 0 && month <= paymentHistory.length){

            for (int i=0; i <month; ++i){
                totalPaid += paymentHistory[i];
            }
        }

        return totalPaid;
    }

    public double getTotalPaidWithInterestRate(){
//        double totalPaid = Arrays.stream(paymentSchedule).sum();
//
//        return totalPaid;

        return sumInterestRate;
    }

    public double [] getPaymentSchedule(){
        return paymentSchedule;
    }

    public double [] getPaymentHistory(){
        return paymentHistory;
    }

    public void pay(int month){
        checkDate(month);

        if (month < 0 && month >= paymentSchedule.length){
            throw new ArrayIndexOutOfBoundsException("month out of paymentSchedule's bounds");
        }

        paymentHistory[month] = paymentSchedule[month];
        paymentSchedule[month] = 0;
    }
}
