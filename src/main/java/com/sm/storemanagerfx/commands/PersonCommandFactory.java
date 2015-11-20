/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sm.storemanagerfx.commands;

import com.sm.storemanagerfx.dao.CustomerDAO;
import com.sm.storemanagerfx.entity.Customer;
import com.sm.storemanagerfx.entity.Employee;

/**
 *
 * @author Sven
 */
class PersonCommandFactory {

    private final CustomerDAO customerDAO;
    
    public PersonCommandFactory(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }
    
    public BaseCommand createAddCustomerCommand(Customer person) {
        return new AddCustomerCommand(customerDAO, person);
    }
    
    public BaseCommand createEditCustomerCommand(Customer person) {
        return null;
    }
    
    public BaseCommand createRemoveCustomerCommand(Customer person) {
        return null;
    }
    
    public BaseCommand createAddPersonCommand(Employee person) {
        return null;
    }
}
