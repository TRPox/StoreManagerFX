/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sm.storemanagerfx.commands;

import com.sm.storemanagerfx.dao.CustomerDAO;
import com.sm.storemanagerfx.entity.Customer;

/**
 *
 * @author Sven
 */
public class AddCustomerCommand implements BaseCommand{

    private final CustomerDAO customerDAO;
    private final Customer customer;

    public AddCustomerCommand(CustomerDAO customerDAO, Customer customer) {
        this.customerDAO = customerDAO;
        this.customer =  customer;
    }
    
    @Override
    public void execute() {
        customerDAO.add(customer);
    }

    @Override
    public void undo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
