package Credit;

import java.time.LocalDate;

public class Credit {
    long sum;
    int interestRate;
    LocalDate dateTake;
    LocalDate dateGive;
    long [] paymentHistory;

    public Credit(long sum, int interestRate, LocalDate dateTake, int duration){
        this.sum = sum;
        this.interestRate = interestRate;
        this.dateTake = dateTake;
        this.dateGive = dateGive;
    }

    public Credit(long sum, int interestRate, LocalDate dateTake, LocalDate dateGive){

    }

}
