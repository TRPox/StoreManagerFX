/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.sm.storemanagerfx.util.InputValidator;
import com.sm.storemanagerfx.dao.EmployeeDAO.EmployeeNotFoundException;
import org.junit.Test;

/**
 *
 * @author Sven
 */
public class EmployeeDAORejectingTest extends EmployeeDAOTest{
    
    @Test(expected = InputValidator.InvalidInputException.class)
    public void givenEmptyStrings_ShouldThrowInvalidInputException() {
        dao.findEmployeesByName("", "");
    }
    
    @Test(expected = InputValidator.InvalidInputException.class)
    public void givenNull_ShouldThrowInvalidInputException() {
        dao.findEmployeesByName(null, null);
    }
    
    @Test(expected = EmployeeNotFoundException.class)
    public void givenInvalidId_shoudThrowEmployeeNotFoundException() {
        dao.findEmployeeById(Integer.MAX_VALUE);
    }
    
}
