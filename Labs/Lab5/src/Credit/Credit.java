package Credit;

import java.util.HashMap;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

public class Credit {

    protected static int minSum = 10000;
    protected static int minDurationMonth = 6;
    protected static double interestRate = 0.2;
    protected static double  interestRateMonth = interestRate/12;
    static double firstPaymentPart = 0.3;

    double body, total;
    int durationMonth;
    Date dateTake, dateGive;
    HashMap <String, Double> paymentHistory, paymentSchedule;

    Calendar c = Calendar.getInstance();
    String dateFormat = "MM-yyyy";
    SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);

    public Credit(double sum){
        checkSum(sum);
        Date dateTake = new Date();
        Date dateGive = addDate(dateTake, minDurationMonth);

        setBody(sum);
        setDurationMonth(minDurationMonth);
        initTotal();

        setDateTake(dateTake);
        setDateGive(dateGive);
        initPaymentSchedule(dateTake, this.durationMonth);
        initPaymentHistory();
    }

    public Credit(double sum, int duration){
        checkSum(sum);
        checkDuration(duration);

        Date dateTake = new Date();
        Date dateGive = addDate(dateTake, duration);

        setBody(sum);
        setDurationMonth(durationMonth);
        initTotal();

        setDateTake(dateTake);
        setDateGive(dateGive);
        initPaymentSchedule(dateTake, this.durationMonth);
        initPaymentHistory();
    }

    public Credit(double sum, String dateTakeS, String dateGiveS){
        checkSum(sum);
        checkDateS(dateTakeS);
        checkDateS(dateGiveS);

        dateTake = keyToDate(dateTakeS);
        dateGive = keyToDate(dateGiveS);
        durationMonth = getDurationMonth(dateTake, dateGive);

        setBody(sum);
        setDurationMonth(durationMonth);
        initTotal();

        setDateTake(dateTake);
        setDateGive(dateGive);
        initPaymentSchedule(dateTake, durationMonth);
        initPaymentHistory();
    }

    public Credit(Credit anotherCredit){

        this.body = anotherCredit.getBody();
        this.total = anotherCredit.getTotal();
        this.dateTake = keyToDate(anotherCredit.getDateTake());
        this.dateGive = keyToDate(anotherCredit.getDateGive());
        this.durationMonth = anotherCredit.getDuration();
        this.paymentSchedule = new HashMap<String, Double> (anotherCredit.getPaymentSchedule());
        this.paymentHistory = new HashMap<String, Double> (anotherCredit.getPaymentHistory());
   }

    // --------------- Interface

    public double getBody(){
        return body;
    }

    public double getTotal(){
        return total;
    }

    public int getDuration() {
        return durationMonth;
    }

    public String getDateTake() {
        return dateToKey(dateTake);
    }

    public String getDateGive(){
        return dateToKey(dateGive);
    }

    public HashMap getPaymentHistory() {
        return paymentHistory;
    }

    public HashMap getPaymentSchedule(){
        return paymentSchedule;
    }

    public double getPaymentSchedule(String dateS){
        checkDateS(dateS);

        return paymentSchedule.get(dateS);
    }

    public double getTotalPaid(String dateS){
        checkDateS(dateS);

        Date startDate = dateTake;
        Date endDate = keyToDate(dateS);
        c.setTime(startDate);
        double totalSum = 0;

        while(getDurationMonth(c.getTime(), endDate) != 0){
            totalSum += getPaymentHistory(dateToKey(c.getTime()));
        }

        return totalSum;
    }

    public double getPaymentHistory(String dateS){
        checkDateS(dateS);
        double record = paymentHistory.containsKey(dateS)? paymentHistory.get(dateS): 0;
        return record;
    }

    public void pay(String dateS){
        checkDateS(dateS);

        paymentHistory.put(dateS, paymentSchedule.get(dateS));
        paymentSchedule.put(dateS, 0.);
        body -= paymentSchedule.get(dateS);
    }

    public double getInterestRate() { return interestRate; }

    public double getInterestRateMonth() { return interestRateMonth; }

    // --------------- Setters

    void setBody(double sum){ body = sum; }

    void initTotal(){
        total = (1+interestRate/12*durationMonth)*body;
    }

     void setDurationMonth(int durationMonth) { this.durationMonth = durationMonth;}

     void setDateTake(Date d){ dateTake = d; }

     void setDateGive(Date d){ dateGive = d; }

     void initPaymentSchedule(Date dateTake, int duration){
        paymentSchedule = new HashMap();

        double firstPayment = total*firstPaymentPart;
        double otherPayment = total*(1-firstPaymentPart)/durationMonth;
        c.setTime(dateTake);
        paymentSchedule.put(dateToKey(c.getTime()), firstPayment);
        for(int i=1; i<durationMonth; ++i){
            c.setTime(dateTake);
            c.add(Calendar.MONTH, i);
            paymentSchedule.put(dateToKey(c.getTime()), otherPayment);
        }
    }

     void initPaymentHistory(){
        paymentHistory = new HashMap();
    }

    // --------------- Helpers

     void checkSum(double sum){

    }

     void checkDateS(String dateS){

    }

     void checkDuration(int duration){

    }

     String dateToKey(Date d){
        String key = sdf.format(d);
        return key;
    }

     Date keyToDate(String key){
        try {
            return sdf.parse(key);
        } catch (java.text.ParseException pe) {
            throw new IllegalArgumentException(String.format("Incorrect date format, expect %s", dateFormat));
        }
    }

     int getDurationMonth(Date a, Date b){
        c.setTime(a);
        int y1 = c.get(Calendar.YEAR), m1 = c.get(Calendar.MONTH);
        c.setTime(b);
        int y2 = c.get(Calendar.YEAR), m2 = c.get(Calendar.MONTH);
        int duration  = (y2 - y1)*12 + m2 - m1;

        return duration;
    }

     Date addDate(Date d, int months){
        c.setTime(d);
        c.add(Calendar.MONTH, months);

        return new Date();
    }

     Date addDate(Date d1, Date d2){

        return new Date();
    }
}
