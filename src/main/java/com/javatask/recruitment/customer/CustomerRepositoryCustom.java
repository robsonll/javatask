package com.javatask.recruitment.customer;

import java.util.List;

public interface CustomerRepositoryCustom {
    List<Customer> findByFilmId(String filmId);
}
