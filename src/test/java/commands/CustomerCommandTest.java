/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import com.sm.storemanagerfx.commands.CommandFactory;
import com.sm.storemanagerfx.dao.CustomerDAO;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import org.junit.Before;

/**
 *
 * @author marcus
 */
public class CustomerCommandTest {

    protected CustomerDAO customerDAO;
    protected CommandFactory commandFactory;
    
    @Before
    public void setUp() {
        customerDAO = new CustomerDAO();
        commandFactory = new CommandFactory(customerDAO);
    }
    
    protected Map<String, Object> createValidMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("id", 1);
        map.put("firstName", "validFirstName");
        map.put("lastName", "validLastName");
        map.put("street", "validStreet");
        map.put("postalCode", "validPostalCode");
        map.put("city", "validCity");
        map.put("phone", "validPhone");
        map.put("email", "validEmail");
        map.put("birthday", LocalDate.of(1990, 12, 13));
        return map;
    }
}
