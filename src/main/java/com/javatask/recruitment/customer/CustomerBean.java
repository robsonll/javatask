package com.javatask.recruitment.customer;

import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named("customerView")
@ViewScoped
public class CustomerBean implements Serializable {

    private List<Customer> customers;
    private Customer selectedCustomer;

    @Inject
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerRepositoryImpl customerRepositoryImpl;

    @PostConstruct
    public void init() {
        customers = customerRepository.findAll();
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setService(CustomerRepository service) {
        this.customerRepository = customerRepository;
    }

    public Customer getSelectedCustomer() {
        return selectedCustomer;
    }

    public void setSelectedCustomer(Customer selectedCustomer) {
        this.selectedCustomer = selectedCustomer;
    }

    public List<Customer> getCustomerListByFilmId(String filmId){
        return customerRepositoryImpl.findByFilmId(filmId);
    }

}
