package Credit;


public class CreditUniform extends Credit{

     void initPaymentSchedule(){
        paymentSchedule = new double [duration];

        double monthPayment = sum/duration;

        for (int i=0; i<duration; ++i){
            paymentSchedule[i] = monthPayment;
        }

    }

    public CreditUniform(long sum, int dateTake, int dateGive){
        super(sum, dateTake, dateGive);
        initPaymentSchedule();
    }

    public double getTotalPaid(int month){
        checkDate(month);

        double totalPaid = 0;
        if (month >= 0 && month < paymentHistory.length){

            for (int i=0; i <= month; ++i){
                totalPaid += paymentHistory[i];
            }
        }

        return totalPaid;
    }

    public double getTotalPaid(){
        double totalPaid = 0;

        for (int i=0; i <= dateGive; ++i) {
            totalPaid += paymentHistory[i];
        }

        return totalPaid;
    }
}
