package com.javatask.recruitment.film;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "films")
public class Film {

    @Id
    private String id;
    @Field("Actors")
    private List<Actor> actors;
    @Field("Category")
    private String category;
    @Field("Description")
    private String description;
    @Field("Length")
    private String length;
    @Field("Rating")
    private String rating;
    @Field("Rental Duration")
    private String rentalDuration;
    @Field("Replacement Cost")
    private String replacementCost;
    @Field("Special Features")
    private String specialFeatures;
    @Field("Title")
    private String title;

}
