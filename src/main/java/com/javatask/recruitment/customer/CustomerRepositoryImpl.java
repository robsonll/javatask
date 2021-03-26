package com.javatask.recruitment.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepositoryCustom{

    private final MongoTemplate mongoTemplate;

    @Autowired
    public CustomerRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<Customer> findByFilmId(String filmId) {

        Query query = new Query();
        query.addCriteria(Criteria.where("Rentals.filmId").is(filmId));

        List<Customer> listCustomer = mongoTemplate.find(query, Customer.class);

        //TODO - verify why query is not fetching anyone
        //List<Customer> listCustomer = mongoTemplate.findAll(Customer.class);

        return listCustomer;
    }


}
