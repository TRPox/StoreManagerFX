/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.sm.storemanagerfx.dao.CustomerDAO;
import com.sm.storemanagerfx.entity.Appointment;
import com.sm.storemanagerfx.entity.Employee;
import com.sm.storemanagerfx.util.InputValidator.InvalidInputException;
import org.junit.Test;

/**
 *
 * @author Sven
 */
public class CustomerDAORejectingTest extends CustomerDAOTest {

    @Test(expected = ClassCastException.class)
    public void givenAppointmentAsNewCustomer_shouldThrowWrongEntityException() {
        dao.add(new Appointment());
    }
    
    @Test(expected = ClassCastException.class)
    public void givenEmployeeAsNewCustomer_shouldThrowWrongEntityException() {
        dao.add(new Employee());
    }
    
    @Test(expected = ClassCastException.class)
    public void givenAppointmentToRemove_shouldThrowWrongEntityException() {
        dao.remove(new Appointment());
    }
    
    @Test(expected = ClassCastException.class)
    public void givenEmployeeToRemove_shouldThrowWrongEntityException() {
        dao.remove(new Employee());
    }
    
    @Test(expected = InvalidInputException.class)
    public void givenEmptyStrings_ShouldThrowInvalidInputException() {
        dao.findCustomersByName("", "");
    }

    @Test(expected = InvalidInputException.class)
    public void givenNull_ShouldThrowInvalidInputException() {
        dao.findCustomersByName(null, null);
    }

    @Test(expected = CustomerDAO.CustomerNotFoundException.class)
    public void givenInvalidId_shoudThrowCustomerNotFoundException() {
        dao.findCustomerById(Integer.MAX_VALUE);
    }

}
