import deposit.Deposit;
import deposit.DepositInterfaceAdvanced;
import depositStatic.DepositStatic;
import depositDynamic.DepositDynamic;
import rate.RateYear;
import rate.RateQuarter;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        double rateYearConst = 0.4;
        double[] ratesQuarters = {0.2, 0.3, 0.4, 0.5};
        RateYear rateYear = new RateYear(rateYearConst);
        RateQuarter rateQuarter = new RateQuarter(ratesQuarters);

        Deposit depositStatic = new DepositStatic("Deposit static", 1000, rateYear, 12);
        DepositInterfaceAdvanced depositDynamic = new DepositDynamic("Deposit dynamic", 1000, rateQuarter, 4);
        testDeposit(depositStatic);
        testDeposit(depositDynamic);

        DepositInterfaceAdvanced[] deposits = {depositStatic, depositDynamic};
        outputDeposits(deposits);
    }

    static void testDeposit(DepositInterfaceAdvanced deposit) {
        System.out.println("Client's name: " + deposit.getName());
        System.out.println("Deposit sum: " + deposit.getSum());
        System.out.println("Deposit rate : " + deposit.getRate());
        System.out.println("Deposit profit is: " + deposit.calcProfit());
        System.out.println();
    }

    static void outputDeposits(DepositInterfaceAdvanced[] deposits) {
        HashMap<String, Double> depositMap = new HashMap();

        for (DepositInterfaceAdvanced deposit : deposits) {
            depositMap.put(deposit.getName(), 0.);
        }

        for (DepositInterfaceAdvanced deposit : deposits) {
            double profit = depositMap.get(deposit.getName());
            profit += deposit.calcProfit();
            depositMap.put(deposit.getName(), profit);
        }

        HashMap sorted = sortHashMapByValues(depositMap);

        System.out.println("Profit: " + sorted);

        System.out.println("Profit sorted");
        for (Object key : sorted.keySet()) {
            System.out.println(key + " " +sorted.get(key));
        }
    }

    static public LinkedHashMap<String, Double> sortHashMapByValues(
            HashMap<String, Double> passedMap) {
        List<String> mapKeys = new ArrayList<>(passedMap.keySet());
        List<Double> mapValues = new ArrayList<>(passedMap.values());
        Collections.sort(mapValues, Collections.reverseOrder());
        Collections.sort(mapKeys, Collections.reverseOrder());

        LinkedHashMap<String, Double> sortedMap =
                new LinkedHashMap<>();

        Iterator<Double> valueIt = mapValues.iterator();
        while (valueIt.hasNext()) {
            Double val = valueIt.next();
            Iterator<String> keyIt = mapKeys.iterator();

            while (keyIt.hasNext()) {
                String key = keyIt.next();
                Double comp1 = passedMap.get(key);
                Double comp2 = val;

                if (comp1.equals(comp2)) {
                    keyIt.remove();
                    sortedMap.put(key, val);
                    break;
                }
            }
        }
        return sortedMap;
    }
}

