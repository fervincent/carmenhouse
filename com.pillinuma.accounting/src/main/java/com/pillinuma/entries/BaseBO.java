package com.pillinuma.entries;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by fernando on 11/3/16.
 */
public class BaseBO {

    private String id;

    public void setId(String id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name="uuid", strategy="uuid2")
    public String getId() {
        return id;
    }
}
