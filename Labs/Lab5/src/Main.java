import Credit.Credit;
import Credit.CreditPercentage;
import Credit.CreditSpecial;
import Credit.CreditUniform;

import java.util.Arrays;

public class Main {
    public static void main(String [] args){
        testCredit(10000, 3 , 9);
//        testCreditUniform(11000, 1, 8);
//        testCreditPercentage(20000, 0, 7);
//        testCreditSpecial(25000, 0 ,7);
    }

    static private void testCredit(int sum, int dateTake, int dateGive){

        Credit credit = new Credit(sum, dateTake, dateGive);

        int paymentMonth = (dateTake + dateGive)/3;
        int totalPaymentMonth = (dateTake + dateGive)/2;
        int numberPayMonth = (dateTake + dateGive)/2;

        System.out.print("Sum: ");
        System.out.println(sum);

        System.out.print("Interest rate: ");
        System.out.println(credit.getInterestRate());

        System.out.print("Total sum with interest rate: ");
        System.out.println(credit.getTotalPaidWithInterestRate());

        System.out.print("Date when credit taken: ");
        System.out.println(dateTake);
        System.out.print("Date when credit given: ");
        System.out.println(dateGive);

        for(int month=0; month<numberPayMonth; ++month) {
            System.out.print(String.format("Pay for %d month: ", month));
            System.out.println(credit.getPaymentScheduleMonth(month));
            credit.pay(month);
        }

        System.out.print("Payment history: ");
        System.out.println(Arrays.toString(credit.getPaymentHistory()));
        System.out.print("Payment Schedule: ");
        System.out.println(Arrays.toString(credit.getPaymentSchedule()));

        double moneyToPay = credit.getPaymentScheduleMonth(paymentMonth);
        System.out.println(String.format("You should pay %f money in %d month: ",moneyToPay, paymentMonth));

        System.out.print(String.format("Total paid unit %d month: ", totalPaymentMonth));
        System.out.println(credit.getTotalPaid(totalPaymentMonth));
        System.out.print("Total sum with interest rate: ");
        System.out.println(credit.getTotalPaidWithInterestRate());
    }

    static private void testCreditUniform(int sum, int dateTake, int dateGive){
        Credit creditUniform = new CreditUniform(sum, 0, 6);

        int paymentMonth = 0;
        int totalPaymentMonth = 4;
        int numberPayMonth = 3;

        System.out.print("Sum: ");
        System.out.println(sum);

        System.out.print("Interest rate: ");
        System.out.println(creditUniform.getInterestRate());

        System.out.print("Total sum with interest rate: ");
        System.out.println(creditUniform.getTotalPaidWithInterestRate());

        System.out.print("Date when creditUniform taken: ");
        System.out.println(dateTake);
        System.out.print("Date when creditUniform given: ");
        System.out.println(dateGive);

        for(int month=0; month<numberPayMonth; ++month) {
            System.out.print(String.format("Pay for %d month: ", month));
            System.out.println(creditUniform.getPaymentScheduleMonth(month));
            creditUniform.pay(month);
        }

        System.out.print("Payment history: ");
        System.out.println(Arrays.toString(creditUniform.getPaymentHistory()));
        System.out.print("Payment Schedule: ");
        System.out.println(Arrays.toString(creditUniform.getPaymentSchedule()));

        double moneyToPay = creditUniform.getPaymentScheduleMonth(paymentMonth);
        System.out.println(String.format("You should pay %f money in %d month: ",moneyToPay, paymentMonth));

        System.out.print(String.format("Total paid unit %d month: ", totalPaymentMonth));
        System.out.println(creditUniform.getTotalPaid(4));
    }

    static private void testCreditPercentage(int sum, int dateTake, int dateGive){
        CreditPercentage creditPercentage = new CreditPercentage(20000, 0, 6);

        int paymentMonth = 0;
        int totalPaymentMonth = 4;
        int numberPayMonth = 3;

        System.out.print("Sum: ");
        System.out.println(sum);

        System.out.print("Interest rate: ");
        System.out.println(creditPercentage.getInterestRate());

        System.out.print("Total sum with interest rate: ");
        System.out.println(creditPercentage.getTotalPaidWithInterestRate());

        System.out.print("Date when creditPercentage taken: ");
        System.out.println(dateTake);
        System.out.print("Date when creditPercentage given: ");
        System.out.println(dateGive);

        for(int month=0; month<numberPayMonth; ++month) {
            System.out.print(String.format("Pay for %d month: ", month));
            System.out.println(creditPercentage.getPaymentScheduleMonth(month));
            creditPercentage.pay(month);
        }

        System.out.print("Payment history: ");
        System.out.println(Arrays.toString(creditPercentage.getPaymentHistory()));
        System.out.print("Payment Schedule: ");
        System.out.println(Arrays.toString(creditPercentage.getPaymentSchedule()));

        double moneyToPay = creditPercentage.getPaymentScheduleMonth(paymentMonth);
        System.out.println(String.format("You should pay %f money in %d month: ",moneyToPay, paymentMonth));

        System.out.print(String.format("Total paid unit %d month: ", totalPaymentMonth));
        System.out.println(creditPercentage.getTotalPaid(4));
    }

    static private void testCreditSpecial(int sum, int dateTake, int dateGive) {
        CreditSpecial creditSpecial = new CreditSpecial(10000, 0, 6);

        int paymentMonth = 0;
        int totalPaymentMonth = 4;
        int numberPayMonth = 3;

        System.out.print("Sum: ");
        System.out.println(sum);

        System.out.print("Interest rate: ");
        System.out.println(creditSpecial.getInterestRate());

        System.out.print("Total sum with interest rate: ");
        System.out.println(creditSpecial.getTotalPaidWithInterestRate());

        System.out.print("Date when creditSpecial taken: ");
        System.out.println(dateTake);
        System.out.print("Date when creditSpecial given: ");
        System.out.println(dateGive);

        for (int month = 0; month < numberPayMonth; ++month) {
            System.out.print(String.format("Pay for %d month: ", month));
            System.out.println(creditSpecial.getPaymentScheduleMonth(month));
            creditSpecial.pay(month);
        }

        System.out.print("Payment history: ");
        System.out.println(Arrays.toString(creditSpecial.getPaymentHistory()));
        System.out.print("Payment Schedule: ");
        System.out.println(Arrays.toString(creditSpecial.getPaymentSchedule()));

        double moneyToPay = creditSpecial.getPaymentScheduleMonth(paymentMonth);
        System.out.println(String.format("You should pay %f money in %d month: ", moneyToPay, paymentMonth));

        System.out.print(String.format("Total paid unit %d month: ", totalPaymentMonth));
        System.out.println(creditSpecial.getTotalPaid(4));
    }

}
