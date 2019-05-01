import Credit.Credit;

import java.util.Arrays;

public class Main {
    public static void main(String [] args){
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
}
