package com.example.config;

import com.example.account.Account;
import com.example.account.AccountRepository;
import com.example.address.Address;
import com.example.address.AddressType;
import com.example.creditcard.CreditCard;
import com.example.creditcard.CreditCardType;
import com.example.customer.Customer;
import com.example.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pranjal on 10/7/16.
 */

@Service
public class DatabaseInitializer {

  private AccountRepository accountRepository;
  private CustomerRepository customerRepository;

  @Autowired
  public DatabaseInitializer(AccountRepository accountRepository, CustomerRepository customerRepository) {
    this.accountRepository = accountRepository;
    this.customerRepository = customerRepository;
  }

  public void populate() {

    accountRepository.deleteAll();
    customerRepository.deleteAll();


    /*Address address1 = new Address("1600 Amphitheatre Parkway", null,
        "CA", "Mountain View", "United States", AddressType.BILLING, 94041);
    Address address2 = new Address("1600 Parkway", null,
        "MA", "Boston", "United States", AddressType.BILLING, 94042);
    Address address3 = new Address("1600 Amphitheatre Parkway", null,
        "CA", "Mountain View", "United States2", AddressType.BILLING, 94043);
    Address address4 = new Address("1600 Parkway", null,
        "MA", "Boston", "United States", AddressType.BILLING, 94044);
    Address address5 = new Address("1600 Amphitheatre Parkway", null,
        "CA", "Mountain View", "United States", AddressType.BILLING, 94045);
    Address address6 = new Address("1600 Parkway", null,
        "MA", "Boston", "United States", AddressType.BILLING, 94046);
    Address address7 = new Address("1600 Amphitheatre Parkway", null,
        "CA", "Mountain View", "United States", AddressType.BILLING, 94047);
    Address address8 = new Address("1600 Parkway", null,
        "MA", "Boston", "United States", AddressType.BILLING, 94048);
    Address address9 = new Address("1600 Amphitheatre Parkway", null,
        "CA", "Mountain View", "United States", AddressType.BILLING, 94049);
    Address address10 = new Address("1600 Parkway", null,
        "MA", "Boston", "United States", AddressType.SHIPPING, 94050);
    Address address11 = new Address("1600 Amphitheatre Parkway", null,
        "CA", "Mountain View", "United States", AddressType.BILLING, 94051);
    Address address12 = new Address("1600 Parkway", null,
        "MA", "Boston", "United States", AddressType.BILLING, 94052);
    Address address13 = new Address("1600 Amphitheatre Parkway", null,
        "CA", "Mountain View", "United States", AddressType.BILLING, 94053);
    Address address14 = new Address("1600 Parkway", null,
        "MA", "Boston", "United States", AddressType.BILLING, 94054);


    List<Address> addresses = new ArrayList<>();
    addresses.add(address1);
    addresses.add(address2);
    addresses.add(address3);
    addresses.add(address4);
    addresses.add(address5);
    addresses.add(address6);
    addresses.add(address7);
    addresses.add(address8);
    addresses.add(address9);
    addresses.add(address10);
    addresses.add(address11);
    addresses.add(address12);
    addresses.add(address13);
    addresses.add(address14);


    CreditCard creditCard1 = new CreditCard("123456789", CreditCardType.VISA);
    CreditCard creditCard2 = new CreditCard("987654322", CreditCardType.MASTERCARD);
    CreditCard creditCard3 = new CreditCard("1234567891", CreditCardType.AMERICAN_EXPRESS);
    CreditCard creditCard4 = new CreditCard("9876543212", CreditCardType.MASTERCARD);
    CreditCard creditCard5 = new CreditCard("1234567893", CreditCardType.VISA);
    CreditCard creditCard6 = new CreditCard("9876543214", CreditCardType.MASTERCARD);
    CreditCard creditCard7 = new CreditCard("1234567895", CreditCardType.VISA);
    CreditCard creditCard8 = new CreditCard("9876543216", CreditCardType.AMERICAN_EXPRESS);
    CreditCard creditCard9 = new CreditCard("1234567897", CreditCardType.VISA);
    CreditCard creditCard10 = new CreditCard("9876543218", CreditCardType.MASTERCARD);
    CreditCard creditCard11 = new CreditCard("1234567899", CreditCardType.VISA);
    CreditCard creditCard12 = new CreditCard("9876543210", CreditCardType.AMERICAN_EXPRESS);

    List<CreditCard> creditCards = new ArrayList<>();
    creditCards.add(creditCard1);
    creditCards.add(creditCard2);
    creditCards.add(creditCard3);
    creditCards.add(creditCard4);
    creditCards.add(creditCard5);
    creditCards.add(creditCard6);
    creditCards.add(creditCard7);
    creditCards.add(creditCard8);
    creditCards.add(creditCard9);
    creditCards.add(creditCard10);
    creditCards.add(creditCard11);
    creditCards.add(creditCard12);

    Account account = new Account("UserId_0001", "AccountNo_1000", creditCards, addresses);
    Customer customer = new Customer("First1", "Last1", "email1", account);*/


    /*account.addAddress(address1);
    account.addAddress(address2);
    account.addCreditCard(creditCard1);
    account.addCreditCard(creditCard2);*/
//    accountRepository.save(account);
    accountRepository.findAll().subscribe(System.out::println);

//    customerRepository.save(customer);
    customerRepository.findAll().subscribe(System.out::println);
  }
}
