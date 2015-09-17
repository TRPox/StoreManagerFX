/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.sm.storemanagerfx.entity.Customer;
import com.sm.storemanagerfx.entity.Employee;
import com.sm.storemanagerfx.util.InputValidator.InvalidInputException;
import org.junit.Test;

/**
 *
 * @author Sven
 */
public class AppointmentDAORejectingTest extends AppointmentDAOTest {
    
    @Test(expected = ClassCastException.class)
    public void givenCustomerAsNewAppointment_shouldThrowClassCastException() {
        dao.add(new Customer());
    }
    
    @Test(expected = ClassCastException.class)
    public void givenEmployeeAsNewAppointment_shouldThrowClassCastException() {
        dao.add(new Employee());
    }
    
    @Test(expected = ClassCastException.class)
    public void givenCustomerToRemove_shouldThrowClassCastException() {
        dao.remove(new Customer());
    }
    
    @Test(expected = ClassCastException.class)
    public void givenEmployeeToRemove_shouldThrowClassCastException() {
        dao.remove(new Employee());
    }
    
    @Test(expected = InvalidInputException.class)
    public void givenNullasDate_shouldThrowInvalidInputException() {
        dao.findAppointmentsByDate(null);
    }
    
    @Test(expected = InvalidInputException.class)
    public void givenNullasCustomer_shouldThrowInvalidInputException() {
        dao.findAppointmentsByCustomer(null);
    }
    
    @Test(expected = InvalidInputException.class)
    public void givenNullasEmployee_shouldThrowInvalidInputException() {
        dao.findAppointmentsByEmployee(null);
    }
}
