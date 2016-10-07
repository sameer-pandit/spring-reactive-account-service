package com.example.creditcard;

import com.example.data.BaseEntity;
import org.springframework.data.annotation.*;

/**
 * A {@link CreditCard} entity is used for processing payments and belongs
 * to an account.
 *
 * @author Kenny Bastani
 * @author Josh Long
 */
//@Entity
public class CreditCard extends BaseEntity {

    @Id
    private String id;
    private String number;

//    @Enumerated(EnumType.STRING)
    private CreditCardType type;

    public CreditCard() {
    }

    public CreditCard(String number, CreditCardType type) {
        this.number = number;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public CreditCardType getType() {
        return type;
    }

    public void setType(CreditCardType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "id=" + id +
                ", number='" + number.replaceAll("([\\d]{4})(?!$)", "****-") + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
