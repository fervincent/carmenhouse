package com.pillinuma.entries;

import javax.persistence.Entity;

/**
 * Created by fernando on 9/29/16.
 */

@Entity
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
