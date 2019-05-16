import Credit.Credit;
import Credit.CreditPercentage;
import Credit.CreditSpecial;
import Credit.CreditUniform;

import java.util.Calendar;
import java.util.Date;


public class Main {
    public static void main(String [] args){
        testCredit(10000, "11-2019" , "10-2020");
        testCreditPercentage(10000, "12-2019" , "12-2020");
//        testCreditUniform(10000, "11-2019" , "11-2020");
//        testCreditSpecial(10000, "11-2019" , "11-2020");
    }

    static private void testCredit(int sum, String dateTake, String  dateGive){

        Credit credit = new Credit(sum, dateTake, dateGive);

        int paymentMonth = 6;
        int totalPaymentMonth = 8;
        int numberPayMonth = 12;

        System.out.print("Sum: ");
        System.out.println(sum);

        System.out.print("Interest rate: ");
        System.out.println(credit.getInterestRate());

        System.out.print("Total sum with interest rate: ");
        System.out.println(credit.getTotal());

        System.out.print("Date when credit taken: ");
        System.out.println(dateTake);
        System.out.print("Date when credit given: ");
        System.out.println(dateGive);

//        for(int month=0; month<numberPayMonth; ++month) {
//            System.out.print(String.format("Pay for %d month: ", month));
//            System.out.println(credit.getPaymentSchedule());
//            credit.pay(month);
//        }

        System.out.print("Payment history: ");
        System.out.println(credit.getPaymentHistory());
        System.out.print("Payment Schedule: ");
        System.out.println(credit.getPaymentSchedule());

        double moneyToPay = credit.getPaymentSchedule(dateTake);
        System.out.println(String.format("You should pay %f money in %d month: ",moneyToPay, paymentMonth));

        credit.pay(dateTake);

        System.out.print(String.format("Total paid unit %d month: ", totalPaymentMonth));
        System.out.println(credit.getTotalPaid(dateGive));
        System.out.print("Total sum with interest rate: ");
        System.out.println(credit.getTotal());
        System.out.print("Ovepay: ");
        System.out.println(credit.getOverpay());
    }

    static private void testCreditUniform(int sum, String dateTake, String  dateGive){

        CreditUniform credit = new CreditUniform(sum, dateTake, dateGive);

        int paymentMonth = 6;
        int totalPaymentMonth = 8;
        int numberPayMonth = 12;

        System.out.print("Sum: ");
        System.out.println(sum);

        System.out.print("Interest rate: ");
        System.out.println(credit.getInterestRate());

        System.out.print("Total sum with interest rate: ");
        System.out.println(credit.getTotal());

        System.out.print("Date when credit taken: ");
        System.out.println(dateTake);
        System.out.print("Date when credit given: ");
        System.out.println(dateGive);

        credit.pay("10-2019");
        credit.pay("11-2019");
        credit.pay("12-2019");


        System.out.print("Payment history: ");
        System.out.println(credit.getPaymentHistory());
        System.out.print("Payment Schedule: ");
        System.out.println(credit.getPaymentSchedule());

        double moneyToPay = credit.getPaymentSchedule(dateTake);
        System.out.println(String.format("You should pay %f money in %d month: ",moneyToPay, paymentMonth));

        credit.pay(dateTake);

        System.out.print(String.format("Total paid unit %d month: ", totalPaymentMonth));
        System.out.println(credit.getTotalPaid(dateGive));
    }

    static private void testCreditPercentage(int sum, String dateTake, String  dateGive){

    CreditPercentage credit = new CreditPercentage(sum, dateTake, dateGive);

    int paymentMonth = 6;
    int totalPaymentMonth = 8;
    int numberPayMonth = 12;

    System.out.print("Sum: ");
    System.out.println(sum);

    System.out.print("Interest rate: ");
    System.out.println(credit.getInterestRate());

    System.out.print("Total sum with interest rate: ");
    System.out.println(credit.getTotal());

    System.out.print("Date when credit taken: ");
    System.out.println(dateTake);
    System.out.print("Date when credit given: ");
    System.out.println(dateGive);

    double payPart = 1000;

    credit.pay("10-2019", payPart);
    credit.pay("11-2019", payPart);
    credit.pay("12-2019", payPart);
    credit.pay("01-2020", payPart);
    credit.pay("02-2020", payPart);
    credit.pay("03-2020", payPart);
    credit.pay("04-2020", payPart);
    credit.pay("05-2020", payPart);
    credit.pay("06-2020", payPart);
    credit.pay("07-2020", payPart);
    credit.pay("08-2020", payPart);
    credit.pay("09-2020", payPart);
    credit.pay("10-2020", payPart);

    System.out.print("Payment history: ");
    System.out.println(credit.getPaymentHistory());
    System.out.print("Payment Schedule: ");
    System.out.println(credit.getPaymentSchedule());

    double moneyToPay = credit.getPaymentSchedule(dateTake);
    System.out.println(String.format("You should pay %f money in %d month: ",moneyToPay, paymentMonth));

    credit.pay(dateTake);

    System.out.print(String.format("Total paid unit %d month: ", totalPaymentMonth));
    System.out.println(credit.getTotalPaid(dateGive));
    System.out.print("Total sum with interest rate: ");
    System.out.println(credit.getTotal());
    System.out.print("Overpay: ");
    System.out.println(credit.getOverpay());
}

    static private void testCreditSpecial(int sum, String dateTake, String  dateGive){

        CreditSpecial credit = new CreditSpecial(sum, dateTake, dateGive);

        int paymentMonth = 6;
        int totalPaymentMonth = 8;
        int numberPayMonth = 12;

        System.out.print("Sum: ");
        System.out.println(sum);

        System.out.print("Interest rate: ");
        System.out.println(credit.getInterestRate());

        System.out.print("Interest goverment dotation rate: ");
        System.out.println(credit.getGovermentDotationRate());

        System.out.print("Total sum with interest rate: ");
        System.out.println(credit.getTotal());

        System.out.print("Date when credit taken: ");
        System.out.println(dateTake);
        System.out.print("Date when credit given: ");
        System.out.println(dateGive);

        credit.pay("10-2019");

        System.out.print("Payment history: ");
        System.out.println(credit.getPaymentHistory());
        System.out.print("Payment Schedule: ");
        System.out.println(credit.getPaymentSchedule());

        double moneyToPay = credit.getPaymentSchedule(dateTake);

        System.out.println(String.format("You should pay %f money in %d month: ",moneyToPay, paymentMonth));

        credit.pay(dateTake);

        System.out.print(String.format("Total paid unit %d month: ", totalPaymentMonth));
        System.out.println(credit.getTotalPaid(dateGive));
        System.out.print("Total sum with interest rate: ");
        System.out.println(credit.getTotal());
    }

}
