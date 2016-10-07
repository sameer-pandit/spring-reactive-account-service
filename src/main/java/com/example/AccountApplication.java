package com.example;

import com.example.account.Account;
import com.example.account.AccountRepository;
import com.example.address.Address;
import com.example.address.AddressType;
import com.example.config.DatabaseInitializer;
import com.example.creditcard.CreditCard;
import com.example.creditcard.CreditCardType;
import com.example.customer.Customer;
import com.example.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
//import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


/**
 * The {@link AccountApplication} is a cloud-native Spring Boot application that manages
 * a bounded context for @{link Customer}, @{link Account}, @{link CreditCard}, and @{link Address}
 *
 * @author Kenny Bastani
 * @author Josh Long
 */
@SpringBootApplication
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class AccountApplication {
    /*@Autowired
    private AccountRepository accountRepository;
    @Autowired
    private CustomerRepository customerRepository;*/
    public static void main(String[] args) {
        SpringApplication.run(AccountApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(DatabaseInitializer databaseInitializer) {
        return args -> {
            // Initialize the database for end to end integration testing
            databaseInitializer.populate();
        };
    }
    /*@Override
    public void run(String... args) {

        accountRepository.deleteAll();
        customerRepository.deleteAll();
        Account account = new Account("UserId_0001", "AccountNo_1000");

        Address address1 = new Address("1600 Amphitheatre Parkway", null,
            "CA", "Mountain View", "United States", AddressType.BILLING, 94043);
        Address address2 = new Address("1600 Parkway", null,
            "MA", "Boston", "United States", AddressType.BILLING, 94046);

        CreditCard creditCard1 = new CreditCard("123456789", CreditCardType.VISA);
        CreditCard creditCard2 = new CreditCard("987654321", CreditCardType.MASTERCARD);

        Customer customer = new Customer("First1", "Last1", "email1", account);


        account.addAddress(address1);
        account.addAddress(address2);
        account.addCreditCard(creditCard1);
        account.addCreditCard(creditCard2);
        accountRepository.save(account);
        //accountRepository.findAll().subscribe(System.out::println);

        customerRepository.save(customer);
        //customerRepository.findAll().subscribe(System.out::println);

    }*/
}
