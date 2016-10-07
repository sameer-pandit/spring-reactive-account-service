package com.example.account;

import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
//import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * A {@link PagingAndSortingRepository} for the {@link Account} domain class that provides
 * basic data management capabilities that include paging and sorting results.
 *
 * @author Kenny Bastani
 * @author Josh Long
 */

public interface AccountRepository extends ReactiveCrudRepository<Account, String> {
    Flux<Account> findAccountsByUserId(@Param("userId") String userId);
}
