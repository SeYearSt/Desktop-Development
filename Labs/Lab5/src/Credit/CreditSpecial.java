package Credit;

import Credit.Credit;

public class CreditSpecial extends Credit{
    private static double govermentDotationRate = 0.1;

    public CreditSpecial(double sum, String dateTake, String dateGive){
        super(sum, dateTake, dateGive);

        this.total = sum*(1 + Credit.interestRate - govermentDotationRate);
        super.initPaymentSchedule(keyToDate(dateTake), durationMonth);
    }

    public static double getGovermentDotationRate() {
        return govermentDotationRate;
    }
}
