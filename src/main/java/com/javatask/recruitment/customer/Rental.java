package com.javatask.recruitment.customer;

import lombok.*;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Field;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Rental {

    @Field("Film Title")
    private String filmTitle;
    @Field("Payments")
    private List<Payment> payments;
    @Field("Rental Date")
    private String rentalDate;
    @Field("Return Date")
    private String returnDate;
    private String filmId;
    private String rentalId;
    private String staffId;
    @Transient
    private long total;

    public Double getTotalPayment(){
        return payments.stream().mapToDouble(o -> o.getAmount()).sum();
    }

    public Date getFormatedRentalDate(){
        try {
            Date dateConverted = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(rentalDate);
            return dateConverted;
        } catch (ParseException e) {
            return null;
        }
    }

    public Long getRentalDuration(){
        try {

            long diff = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(returnDate).getTime() -
                    new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(rentalDate).getTime();

            return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);

        } catch (ParseException e) {
            e.printStackTrace();
            return 0L;
        }
    }

}
