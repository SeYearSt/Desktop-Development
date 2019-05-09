package Credit;
import Credit.Credit;


public class CreditSpecial extends Credit{
    static double govermentDotationPercent = 0.1;

    void initPaymentSchedule(){
        double firstPaymentPart = 0.3;

        paymentSchedule = new double [duration];

        paymentSchedule[0] = sumWithInterestRate*firstPaymentPart;
        double otherPaymentPart = sumWithInterestRate*(1 - firstPaymentPart)/(duration-1);

        for (int i=1; i<duration; ++i){
            paymentSchedule[i] = otherPaymentPart;
        }
    }

    public CreditSpecial(long sum, int dateTake, int dateGive){
        super(sum, dateTake, dateGive);
        this.sumWithInterestRate = sum*(1 + Credit.interestRate - govermentDotationPercent);
        initPaymentSchedule();
    }
}
