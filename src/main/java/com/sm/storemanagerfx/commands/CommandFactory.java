/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sm.storemanagerfx.commands;

import com.sm.storemanagerfx.dao.CustomerDAO;
import com.sm.storemanagerfx.entity.Appointment;
import com.sm.storemanagerfx.entity.Customer;

/**
 *
 * @author Sven
 */
public class CommandFactory {

    private static PersonCommandFactory personCommandFactory;

    public CommandFactory(CustomerDAO customerDAO) {
        CommandFactory.personCommandFactory = new PersonCommandFactory(customerDAO);
    }
    
    public BaseCommand createCommand(CommandType type, Appointment appointment) {
        switch (type) {
            case ADD:
                return createAddCommand();
            case EDIT:
                return createEditCommand();
            case REMOVE:
                return createRemoveCommand();
            default:
                throw new InvalidCommandTypeException();
        }
    }

    public BaseCommand createCommand(CommandType type, Customer entity) {
        switch (type) {
            case ADD:
                return personCommandFactory.createAddCustomerCommand(entity);
            case EDIT:
                return personCommandFactory.createEditCustomerCommand(entity);
            case REMOVE:
                return personCommandFactory.createRemoveCustomerCommand(entity);
            default:
                throw new InvalidCommandTypeException();
        }
        
    }

    private BaseCommand createAddCommand() {
        return null;
    }
    
    private BaseCommand createEditCommand() {
        return null;
    }
    
    private BaseCommand createRemoveCommand() {
        return null;
    }
    
    public class InvalidCommandTypeException extends RuntimeException {

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
