/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sm.storemanagerfx.commands;

import com.sm.storemanagerfx.dao.CustomerDAO;
import com.sm.storemanagerfx.util.EntityMapper;
import java.util.Map;

/**
 *
 * @author Sven
 */
public class CommandFactory {

    private final CustomerDAO customerDAO;

    public CommandFactory(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }    
    
    public BaseCommand createAddCommand(EntityType type, Map<String, Object> dataMap) {
        switch (type) {
            case CUSTOMER:
                return new AddCustomerCommand(customerDAO, EntityMapper.createCustomerFromMap(dataMap));
            case APPOINTMENT:
                
            case EMPLOYEE:
                
            default:
                throw new InvalidEntityTypeException();
        }

    }

    public BaseCommand createEditCommand(EntityType type, Map<String, Object> dataMap) {
        switch (type) {
            case CUSTOMER:
                return new EditCustomerCommand(customerDAO, EntityMapper.createCustomerFromMap(dataMap));
            case APPOINTMENT:
                
            case EMPLOYEE:
                
            default:
                throw new InvalidEntityTypeException();
        }

    }

    public BaseCommand createRemoveCommand(EntityType type, Map<String, Object> dataMap) {
        switch (type) {
            case CUSTOMER:
                return new RemoveCustomerCommand(customerDAO, (int) dataMap.get("id"));
            case APPOINTMENT:
                
            case EMPLOYEE:
                
            default:
                throw new InvalidEntityTypeException();
        }

    }

    
    public static class InvalidEntityTypeException extends RuntimeException {

        public InvalidEntityTypeException() {
        }
    }
    
    public enum EntityType {
        CUSTOMER,
        APPOINTMENT,
        EMPLOYEE
    }
}
