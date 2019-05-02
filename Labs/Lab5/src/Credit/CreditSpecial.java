package Credit;
import Credit.Credit;


public class CreditSpecial extends Credit{
    static double govermentDotationPercent = 0.1;

//    private void initPaymentSchedule(){
//        double firstPaymentPart = 0.3;
//
//        paymentSchedule = new double [duration];
//
//        paymentSchedule[0] = sumInterestRate*firstPaymentPart;
//        double otherPaymentPart = sumInterestRate*(1 - firstPaymentPart)/(duration-1);
//
//        for (int i=1; i<duration; ++i){
//            paymentSchedule[i] = otherPaymentPart;
//        }
//    }

    public CreditSpecial(long sum, int dateTake, int dateGive){
        super(sum, dateTake, dateGive);
        this.sumInterestRate = sum*(1 + Credit.interestRate - govermentDotationPercent);
        initPaymentSchedule();
    }
}
