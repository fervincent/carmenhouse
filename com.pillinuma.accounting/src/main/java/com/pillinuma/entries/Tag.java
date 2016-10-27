package com.pillinuma.entries;

/**
 * Created by fernando on 9/29/16.
 */
public class Tag {

    private String name;
    private Operator operator;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public Operator getOperator() {
        return operator;
    }
}
