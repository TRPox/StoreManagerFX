/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.sm.storemanagerfx.dao.EmployeeDAO;
import org.junit.Before;

/**
 *
 * @author Sven
 */
public class EmployeeDAOTest {
    
    protected EmployeeDAO dao;
    
    @Before
    public void setUp() {
        dao = new EmployeeDAO();
    }
    
}
