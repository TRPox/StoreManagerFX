/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sm.storemanagerfx.commands;

import com.sm.storemanagerfx.dao.CustomerDAO;
import com.sm.storemanagerfx.entity.Customer;


public class EditCustomerCommand extends EditEntityCommand {
    
    private final CustomerDAO customerDAO;
    private final Customer customer;

    public EditCustomerCommand(CustomerDAO customerDAO, Customer customer) {
        this.customerDAO = customerDAO;
        this.customer = customer;
    }

    @Override
    public void execute() {
        Customer c = customerDAO.findCustomerById(customer.getId());
        if(customer.getFirstName() != null && !customer.getFirstName().isEmpty()) {
            c.setFirstName(customer.getFirstName());
        }
        if(customer.getLastName() != null && !customer.getLastName().isEmpty()) {
            c.setLastName(customer.getLastName());
        }
        if(customer.getBirthday() != null) {
            c.setBirthday(customer.getBirthday());
        }
        if(customer.getAddress() != null) {
            c.setAddress(customer.getAddress());
        }
    }

    @Override
    public void undo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
