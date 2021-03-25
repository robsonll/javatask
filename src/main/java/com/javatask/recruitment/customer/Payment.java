package com.javatask.recruitment.customer;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Field;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    @Field("Amount")
    private double amount;
    @Field("Payment Date")
    private String paymentDate;
    @Field("Payment Id")
    private String paymentId;

}
