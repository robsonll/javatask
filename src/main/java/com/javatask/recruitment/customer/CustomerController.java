package com.javatask.recruitment.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAllCustomers(@RequestParam(required = false) String title){
        try {
            List<Customer> customers = new ArrayList<Customer>();

            customerRepository.findAll().forEach(customers::add);



            if (customers.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(customers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/customers")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {

        try {
            Customer _customer = customerRepository.save(new Customer(  customer.getId(),
                                                                        customer.getAddress(),
                                                                        customer.getCity(),
                                                                        customer.getCountry(),
                                                                        customer.getDistrict(),
                                                                        customer.getFirstName(),
                                                                        customer.getLastName(),
                                                                        customer.getPhone(),
                                                                        customer.getRentals()));

            return new ResponseEntity<>(_customer, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("/customers/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("id") String id, @RequestBody Customer customer) {

        Optional<Customer> customerData = customerRepository.findById(id);

        if (customerData.isPresent()) {
            Customer _customer = customerData.get();
            _customer.setAddress(customer.getAddress());
            _customer.setCity(customer.getCity());
            _customer.setCountry(customer.getCountry());
            _customer.setDistrict(customer.getDistrict());
            _customer.setFirstName(customer.getFirstName());
            _customer.setLastName(customer.getLastName());
            _customer.setPhone(customer.getPhone());
            _customer.setRentals(customer.getRentals());

            return new ResponseEntity<>(customerRepository.save(_customer), HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable("id") String id) {

        try {
            customerRepository.deleteById(id);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
