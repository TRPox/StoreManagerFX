/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.sm.storemanagerfx.dao.CustomerDAO;
import com.sm.storemanagerfx.util.InputValidator.InvalidInputException;
import org.junit.Test;

/**
 *
 * @author Sven
 */
public class CustomerDAORejectingTest extends CustomerDAOTest {

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
