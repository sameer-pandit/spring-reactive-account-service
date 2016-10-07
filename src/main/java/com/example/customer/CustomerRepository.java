package com.example.customer;

//import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * A {@link PagingAndSortingRepository} for the {@link Customer} domain class that provides
 * basic data management capabilities that include paging and sorting results.
 *
 * @author Kenny Bastani
 * @author Josh Long
 */

public interface CustomerRepository extends ReactiveCrudRepository<Customer, String> {

  Mono<Customer> findByFirstName(String firstName);
  Flux<Customer> findByLastName(String lastName);
}
