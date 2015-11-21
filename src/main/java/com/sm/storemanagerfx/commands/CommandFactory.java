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
public class CommandFactory {

    private static CommandFactory instance;
    private static PersonCommandFactory personCommandFactory;

    private CommandFactory(CustomerDAO customerDAO) {
        personCommandFactory = new PersonCommandFactory(customerDAO);
    }

    public static CommandFactory createInstance(CustomerDAO customerDAO) {
        if(instance == null) {
            instance = new CommandFactory(customerDAO);
        }
        return instance;
    }
    
    public static CommandFactory getInstance() {
        if(instance != null) {
            return instance;
        }
        return null;
    }
    
    public static BaseCommand createCustomerCommand(CommandType type, Customer entity) {
        switch (type) {
            case ADD:
                return personCommandFactory.createAddCustomerCommand(entity);
            case EDIT:
                return personCommandFactory.createEditCustomerCommand(entity);
            case REMOVE:
                return personCommandFactory.createRemoveCustomerCommand(entity.getId());
            default:
                throw new InvalidCommandTypeException();
        }

    }

    public static class InvalidCommandTypeException extends RuntimeException {

        public InvalidCommandTypeException() {
        }
    }

    public enum CommandType {

        ADD,
        EDIT,
        REMOVE,
        ADD_IGNORE_COLLISION,
        EDIT_IGNORE_COLLISION
    }
}
