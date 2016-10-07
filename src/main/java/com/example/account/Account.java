package com.example.account;

import com.example.creditcard.CreditCard;
import com.example.address.Address;
import com.example.customer.Customer;
import com.example.data.BaseEntity;

import org.springframework.data.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * This entity stores information about a {@link Customer}'s {@link Account}.
 *
 * @author Kenny Bastani
 * @author Josh Long
 */

public class Account extends BaseEntity {

    @Id
    private String id;
    private String userId;
    private String accountNumber;
    private Boolean defaultAccount;
    private List<CreditCard> creditCards = new ArrayList<>();
    private List<Address> addresses = new ArrayList<>();

    public Account() {
    }

    public Account(String userId, String accountNumber, List<CreditCard>creditCards, List<Address>addresses) {
        this.userId = userId;
        this.accountNumber = accountNumber;
        this.creditCards = creditCards;
        this.addresses = addresses;
        this.defaultAccount = false;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Boolean getDefaultAccount() {
        return defaultAccount;
    }

    public void setDefaultAccount(Boolean defaultAccount) {
        this.defaultAccount = defaultAccount;
    }

    //@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public List<CreditCard> getCreditCards() {
        return creditCards;
    }

    public void setCreditCards(List<CreditCard> creditCards) {
        this.creditCards = creditCards;
    }

    //@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public void addCreditCard(CreditCard creditCard) {
        creditCards.add(creditCard);
    }

    public void addAddress(Address address) {
        addresses.add(address);
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", accountNumber='" + accountNumber + '\'' +
                ", creditCards=" + creditCards +
                ", addresses=" + addresses +
                "} " + super.toString();
    }
}
