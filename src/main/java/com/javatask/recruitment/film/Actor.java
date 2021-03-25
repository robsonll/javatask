package com.javatask.recruitment.film;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Field;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Actor {

    private String actorId;
    @Field("First name")
    private String firstName;
    @Field("Last name")
    private String lastName;

}
