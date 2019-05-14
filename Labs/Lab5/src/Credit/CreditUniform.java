package Credit;

import java.util.HashMap;
import java.util.Calendar;
import java.text.ParseException;

public class CreditUniform extends Credit{

    public CreditUniform(double sum, String dateTakeS, String dateGiveS){
         super(sum, dateTakeS, dateGiveS);
         initPaymentSchedule();
    }

    void initPaymentSchedule(){
        paymentSchedule = new HashMap<String, Double>();

        double payment = total/durationMonth;
        for(int i=0; i<durationMonth; ++i){
            c.setTime(dateTake);
            c.add(Calendar.MONTH, i);
            paymentSchedule.put(dateToKey(c.getTime()), payment);
        }
    }


}
