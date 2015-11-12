/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sm.storemanagerfx.interfaces.impl;

import com.sm.storemanagerfx.entity.Customer;
import com.sm.storemanagerfx.interfaces.AddedEntityRequestModel;
import com.sm.storemanagerfx.outputentity.OutputCustomer;
import java.util.List;

/**
 *
 * @author Sven
 */
public class AddedCustomerRequest implements AddedEntityRequestModel<OutputCustomer>{

    private List<Customer> addedList;
    
    @Override
    public void add(OutputCustomer entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(OutputCustomer entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
