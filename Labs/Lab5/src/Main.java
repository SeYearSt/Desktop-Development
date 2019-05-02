import Credit.Credit;
import Credit.CreditPercentage;
import Credit.CreditSpecial;
import Credit.CreditUniform;

import java.util.Arrays;

public class Main {
    public static void main(String [] args){
//        testCredit();
//        testCreditPercentage();
        testCreditSpecial();
//        testCreditUniform();

    }

    static private void testCredit(){
        Credit credit = new Credit(10000, 0, 6);

        credit.pay(2);
        credit.pay(1);
        credit.pay(0);

        System.out.println(Arrays.toString(credit.getPaymentHistory()));
        System.out.println(Arrays.toString(credit.getPaymentSchedule()));
        System.out.println(credit.getPaymentScheduleMonth(0));
        System.out.println(credit.getTotalPaid(4));
        System.out.println(credit.getTotalPaidWithInterestRate());

    }

    static private void testCreditPercentage(){
        CreditPercentage creditPercentage = new CreditPercentage(20000, 0, 6);

        System.out.print("Payment schedule init: ");
        System.out.println(Arrays.toString(creditPercentage.getPaymentSchedule()));

        creditPercentage.pay(creditPercentage.getPaymentScheduleMonth(0) - 100, 0);
//        creditPercentage.pay(1);
//        creditPercentage.pay(2);

        System.out.print("Payment history.");
        System.out.println(Arrays.toString(creditPercentage.getPaymentHistory()));
        System.out.print("Payment schedule after payments.");
        System.out.println(Arrays.toString(creditPercentage.getPaymentSchedule()));
        System.out.println(creditPercentage.getPaymentScheduleMonth(0));
        System.out.println(creditPercentage.getTotalPaid(4));
        System.out.println(creditPercentage.getTotalPaidWithInterestRate());
    }

    static private void testCreditSpecial(){
        CreditSpecial creditSpecial = new CreditSpecial(10000, 0, 6);

        System.out.print("Payment schedule init: ");
        System.out.println(Arrays.toString(creditSpecial.getPaymentSchedule()));

        creditSpecial.pay(0);
        creditSpecial.pay(1);
//        creditSpecial.pay(2);

        System.out.print("Payment history.");
        System.out.println(Arrays.toString(creditSpecial.getPaymentHistory()));
        System.out.print("Payment schedule after payments.");
        System.out.println(Arrays.toString(creditSpecial.getPaymentSchedule()));
//        System.out.println(creditPercentage.getPaymentScheduleMonth(0));
        System.out.println(creditSpecial.getTotalPaid(4));
        System.out.println(creditSpecial.getTotalPaidWithInterestRate());

    }

    static private void testCreditUniform(){
        Credit creditUniform = new CreditUniform(10000, 0, 6);

    }
}
