/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sm.storemanagerfx.commands;

import com.sm.storemanagerfx.dao.CustomerDAO;

/**
 *
 * @author Sven
 */
public class RemoveCustomerCommand extends RemoveEntityCommand{
    
    private final CustomerDAO customerDAO;

    public RemoveCustomerCommand(CustomerDAO customerDAO, int id) {
        super(id);
        this.customerDAO = customerDAO;
    }

    @Override
    public void execute() {
        customerDAO.remove(id);
    }

    @Override
    public void undo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
