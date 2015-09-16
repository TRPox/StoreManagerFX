/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.sm.storemanagerfx.dao.AppointmentDAO;
import org.junit.Before;

/**
 *
 * @author Sven
 */
public class AppointmentDAOTest {
    
    protected AppointmentDAO dao;
    
    @Before
    public void setUp() {
        dao = new AppointmentDAO();
    }
    
}
