import deposit.Deposit;
import deposit.DepositInterfaceAdvanced;
import depositStatic.DepositStatic;
import depositDynamic.DepositDynamic;
import rate.RateYear;
import rate.RateQuarter;

public class Main {
    public static void main(String [] args){
        double rateYearConst = 0.4;
        double[] ratesQuarters = {0.2, 0.3, 0.4, 0.5};
        RateYear rateYear = new RateYear(rateYearConst);
        RateQuarter rateQuarter = new RateQuarter(ratesQuarters);

        Deposit depositStatic = new DepositStatic("John", 1000, rateYear, 12);
        DepositInterfaceAdvanced depositDynamic = new DepositDynamic("Sandy", 2000, rateQuarter, 4);
        testDeposit(depositStatic);
        testDeposit(depositDynamic);
    }

    static void testDeposit(DepositInterfaceAdvanced deposit){
        System.out.println("Client's name: " + deposit.getName());
        System.out.println("Deposit sum: " + deposit.getSum());
        System.out.println("Deposit rate : " + deposit.getRate());
        System.out.println("Deposit profit is: " + deposit.calcProfit());
        System.out.println();
    }
}
