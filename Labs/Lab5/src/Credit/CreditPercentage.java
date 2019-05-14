package Credit;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import Credit.Credit;

public class CreditPercentage extends Credit {
    private double startBody;

    public CreditPercentage(double sum, String dateTakeS, String dateGiveS) {
        super(sum, dateTakeS, dateGiveS);
        setStartBody(sum);
        initPaymentSchedule(keyToDate(getDateTake()), getDuration());
    }

    void initPaymentSchedule(Date dateTake, int duration) {
        paymentSchedule = new HashMap<String, Double>();

        for (int i = 0; i < durationMonth; ++i) {
            c.setTime(dateTake);
            c.add(Calendar.MONTH, i);
            paymentSchedule.put(dateToKey(c.getTime()), 0.);
        }

        paymentSchedule.put("percents", 0.);
    }

    public void pay(String dateS, double sum){
        checkDateS(dateS);
        checkSum(sum);

        paymentHistory.put(dateS, sum);
        body -= sum;
        double percents = paymentSchedule.get("percents");
        percents += body*interestRateMonth;
        paymentSchedule.put("percents", percents);
    }

    public double getTotal(){
        return getPaymentSchedule("percents") + startBody;
    }

    private void setStartBody(double sum){ startBody = sum; }

}
