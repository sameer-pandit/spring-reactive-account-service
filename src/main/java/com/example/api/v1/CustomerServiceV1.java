package com.example.api.v1;

import com.example.customer.Customer;
import com.example.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

/**
 * Created by pranjal on 10/7/16.
 */

@Service
public class CustomerServiceV1 {

  private CustomerRepository customerRepository;

  @Autowired
  public CustomerServiceV1(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  public Flux<Customer> getCustomers() {


    return customerRepository.findAll();
  }
}
