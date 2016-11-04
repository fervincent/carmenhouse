package com.pillinuma.accounting.carmen;

import com.pillinuma.entries.Company;
import com.pillinuma.entries.Repository;

/**
 * Created by fabad on 02/11/2016.
 */
public class CarmenAccounting extends Repository {

    public CarmenAccounting() {
        super(new Company("Carmen Josefina Tandazo Abad"));
    }
}
