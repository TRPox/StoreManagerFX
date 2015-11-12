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
public class CommandFactory {

    private static CustomerDAO customerDAO;

    public CommandFactory(CustomerDAO customerDAO) {
        CommandFactory.customerDAO = customerDAO;
    }

    public static BaseCommand createCommand(CommandType type) {
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

    private static BaseCommand createAddCommand() {
        return null;
    }
    
    private static BaseCommand createEditCommand() {
        return null;
    }
    
    private static BaseCommand createRemoveCommand() {
        return null;
    }
    
    public static class InvalidCommandTypeException extends RuntimeException {

        public InvalidCommandTypeException() {
        }
    }

    public enum CommandType {

        ADD,
        EDIT,
        REMOVE
    }
}
