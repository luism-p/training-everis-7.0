package com.liferay.training.customers.util;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.trainin.customers.model.Customer;

public class CustomerValidator {
    public static boolean isCustomerValid(Customer customer){
        boolean result = Boolean.TRUE;

        if(Validator.isBlank(customer.getName())){
            result = Boolean.FALSE;
        }

        if(Validator.isBlank(customer.getPhoneNumber())){
            result = Boolean.FALSE;
        }

        if(!customer.isNew() && Validator.isNull(customer.getCustomerId())){
            result = Boolean.FALSE;
        }

        return result;
    }

}
