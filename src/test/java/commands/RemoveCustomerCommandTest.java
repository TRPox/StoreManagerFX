/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import com.sm.storemanagerfx.commands.BaseCommand;
import com.sm.storemanagerfx.commands.CommandFactory.EntityType;
import com.sm.storemanagerfx.dao.CustomerDAO.CustomerNotFoundException;
import com.sm.storemanagerfx.entity.Customer;
import java.util.HashMap;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Sven
 */
public class RemoveCustomerCommandTest extends CustomerCommandTest{
    
    private Customer customer;
    
    @Before
    public void addCustomerToDAO() {
        BaseCommand command = commandFactory.createAddCommand(EntityType.CUSTOMER, createValidMap());
        command.execute();
    }
    
    @Test(expected = CustomerNotFoundException.class)
    public void givenID_shouldRemoveFromDAO() {
        Map<String, Object> dataMap = new HashMap();
        dataMap.put("id", 1);
        BaseCommand command = commandFactory.createRemoveCommand(EntityType.CUSTOMER, dataMap);
        command.execute();
        customerDAO.findCustomerById(1);
    }
}
