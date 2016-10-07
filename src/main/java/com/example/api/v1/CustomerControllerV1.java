package com.example.api.v1;

import com.example.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * Created by pranjal on 10/7/16.
 */

@RestController
@RequestMapping(path = "/v1")
public class CustomerControllerV1 {

  private CustomerServiceV1 customerService;

  @Autowired
  public CustomerControllerV1(CustomerServiceV1 customerService) {
    this.customerService = customerService;
  }

  @RequestMapping(path = "/customers")
  public Flux<Customer> getUserAccount() throws Exception {
    return customerService.getCustomers();
  }
}
