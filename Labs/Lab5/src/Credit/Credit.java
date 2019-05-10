package Credit;


public class Credit {
    protected long sum;
    protected int dateTake, dateGive, duration;
    protected double [] paymentHistory;
    protected double [] paymentSchedule;
    protected double sumWithInterestRate;

    protected static long minSum = 10000;
    protected static int minDuration = 6;
    protected static double interestRate = 0.2;
    protected static int firstMonth = 0;
    protected static int lastMonth = 11;

    void initPaymentSchedule(){
        double firstPaymentPart = 0.3;

        paymentSchedule = new double[dateGive];

        paymentSchedule[dateTake] = sumWithInterestRate*firstPaymentPart;
        double otherPaymentPart = sumWithInterestRate*(1 - firstPaymentPart)/(duration-1);

        for (int i=dateTake+1; i<dateGive; ++i){
            paymentSchedule[i] = otherPaymentPart;
        }
    }

    void checkDate(int date){
        if (date < Credit.firstMonth || date > Credit.lastMonth ){
            throw new IllegalArgumentException(String.format("date cannot be less than %d or more than %d",
                    Credit.firstMonth, Credit.lastMonth));
        }
    }

    void checkSum(double sum){
        if (sum <= 0 || sum < Credit.minSum){
            throw new IllegalArgumentException(String.format("Sum cannot be less than zero " +
                    "or then minimal sum = %d", Credit.minSum));
        }
    }

    public Credit(long sum, int dateTake, int dateGive){
        checkSum(sum);
        checkDate(dateTake);
        checkDate(dateGive);

        int duration = dateGive - dateTake;
        if (duration < Credit.minDuration){
            throw new IllegalArgumentException(String.format("duration cannot be less than %d", Credit.minDuration));
        }

        this.sum = sum;
        this.sumWithInterestRate = (1+Credit.interestRate)*sum;
        this.duration = duration;
        this.dateTake = dateTake;
        this.dateGive = dateGive;
        paymentHistory = new double [duration];

        initPaymentSchedule();
    }

    public Credit(long sum, int dateTake, short duration){
        int durationInt = (int) duration;

        checkSum(sum);
        checkDate(dateTake);

        if (duration < Credit.minDuration){
            throw new IllegalArgumentException(String.format("duration cannot be less than %d", Credit.minDuration));
        }

        if ((dateTake + duration) > lastMonth){
            throw new IllegalArgumentException(String.format("duration + dateTake cannot be greater than %d", Credit.lastMonth));
        }

        this.sum = sum;
        this.sumWithInterestRate = (1+Credit.interestRate)*sum;
        this.duration = durationInt;
        this.dateTake = dateTake;
        this.dateGive = dateTake + duration;
        paymentHistory = new double [durationInt];

        initPaymentSchedule();

    }

    public Credit(Credit anotherCredit){

        this.sum = anotherCredit.getSum();
        this.sumWithInterestRate = anotherCredit.getSumWithInterestRate();
        this.dateTake = anotherCredit.getDateTake();
        this.dateGive = anotherCredit.getDateGive();
        this.duration = anotherCredit.getDuration();
        this.paymentSchedule = anotherCredit.getPaymentSchedule().clone();
        this.paymentHistory = anotherCredit.getPaymentHistory().clone();
   }

    public long getSum(){ return sum; }

    public int getDateTake(){ return dateTake; }

    public int getDateGive(){ return dateGive; }

    public int getDuration(){ return duration; }

    public double [] getPaymentHistory(){ return paymentHistory; }

    public  double [] getPaymentSchedule(){ return paymentSchedule; }

    public double getSumWithInterestRate(){ return sumWithInterestRate; }

    public double getInterestRate(){ return interestRate; }

    public double getPaymentScheduleMonth(int month){
        checkDate(month);

        if (month >= 0 && month < paymentSchedule.length){
            return paymentSchedule[month];
        }

        throw new ArrayIndexOutOfBoundsException("month out of paymentSchedule's bounds");
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

    public double getTotalPaidWithInterestRate(){

        return sumWithInterestRate;
    }

    public void pay(int month){
        checkDate(month);

        if (month < 0 && month >= paymentSchedule.length){
            throw new ArrayIndexOutOfBoundsException("month out of paymentSchedule's bounds");
        }

        paymentHistory[month] = paymentSchedule[month];
        paymentSchedule[month] = 0;
    }
}
