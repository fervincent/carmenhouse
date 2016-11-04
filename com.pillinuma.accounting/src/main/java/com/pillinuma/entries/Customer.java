package com.pillinuma.entries;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by fabad on 26/10/2016.
 */
@Entity
public class Customer extends BaseBO {
    private String name;
    private String identification;
    private String reference1;
    private String email;

    public Customer() {
    }

    public Customer(String name, String identification, String reference1) {
        this.name = name;
        this.identification = identification;
        this.reference1 = reference1;
    }

    public Customer(String name, String identification, String reference1, String email) {
        this.name = name;
        this.identification = identification;
        this.reference1 = reference1;
        this.email = email;
    }

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name="uuid", strategy="uuid2")
    public String getId() {
        return super.getId();
    }


    public String getName() {
        return name;
    }


    public String getIdentification() {
        return identification;
    }


    public String getReference1() {
        return reference1;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public void setName(String name) {
        this.name = name;

    }

    public void setReference1(String reference1) {
        this.reference1 = reference1;
    }
}
