package com.pillinuma.entries;

/**
 * Created by fabad on 26/10/2016.
 */
public class Receipt {
    private Customer customer;
    private int number;

    public Receipt(int number, Customer customer) {
        this.number = number;
        this.customer = customer;

    }

    public Customer getCustomer() {
        return customer;
    }
    public int getNumber() {
        return number;
    }

}
