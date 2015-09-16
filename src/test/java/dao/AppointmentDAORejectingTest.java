/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.sm.storemanagerfx.util.InputValidator.InvalidInputException;
import org.junit.Test;

/**
 *
 * @author Sven
 */
public class AppointmentDAORejectingTest extends AppointmentDAOTest {
    
    @Test(expected = InvalidInputException.class)
    public void givenNull_shouldThrowInvalidInputException() {
        dao.findAppointmentsByDate(null);
    }
}
