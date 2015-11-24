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

    private CustomerDAO customerDAO;
    
    public PersonCommandFactory(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    public void setCustomerDAO(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }
    
    public BaseCommand createAddCustomerCommand(Customer person) {
        return new AddCustomerCommand(customerDAO, person);
    }
    
    public BaseCommand createEditCustomerCommand(Customer person) {
        return new EditCustomerCommand(customerDAO, person);
    }
    
    public BaseCommand createRemoveCustomerCommand(int id) {
        return new RemoveCustomerCommand(customerDAO, id);
    }
    
    public BaseCommand createAddPersonCommand(Employee person) {
        return null;
    }
}
