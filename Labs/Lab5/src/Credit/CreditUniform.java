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
}
