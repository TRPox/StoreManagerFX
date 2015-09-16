/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sm.storemanagerfx.util;

/**
 *
 * @author Sven
 */
public class InputValidator {
    
    public static void checkToNull(Object... vars) throws InvalidInputException {
        for(Object o : vars) {
            if(o == null) {
                throw new InvalidInputException();
            }
        }
    }
    
    public static void checkEmptyString(Object... vars) throws InvalidInputException {
        for(Object o : vars) {
            if(o.equals("")) {
                throw new InvalidInputException();
            }
        }
    }
    
    public static void checkEmpty(Object... vars) throws InvalidInputException {
        if(vars.length == 0) {
            throw new InvalidInputException();
        }
    }
    
    public static boolean isValid(Object... vars) {
        checkEmpty(vars);
        checkToNull(vars);
        checkEmptyString(vars);
        return true;
    }
    
    
    public static class InvalidInputException extends RuntimeException {}
}
