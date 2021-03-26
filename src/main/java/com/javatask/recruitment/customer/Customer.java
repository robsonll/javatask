package com.javatask.recruitment.customer;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "customers")
public class Customer {

    @Id
    private String id;
    @Field("Address")
    private String address;
    @Field("City")
    private String city;
    @Field("Country")
    private String country;
    @Field("District")
    private String district;
    @Field("First Name")
    private String firstName;
    @Field("Last Name")
    private String lastName;
    @Field("Phone")
    private String phone;
    @Field("Rentals")
    private List<Rental> rentals;

    //@Transient
    //private long rentalAmount;

    public Double getRentalAmount() {
        return rentals.stream().mapToDouble(o -> o.getTotalPayment()).sum();
    }

}
