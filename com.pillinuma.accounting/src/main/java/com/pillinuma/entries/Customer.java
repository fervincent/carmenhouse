package com.pillinuma.entries;

/**
 * Created by fabad on 26/10/2016.
 */
public class Customer {
    private String name;
    private String identification;
    private String reference1;
    private String email;

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
}
