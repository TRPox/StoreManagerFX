/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import com.sm.storemanagerfx.commands.BaseCommand;
import com.sm.storemanagerfx.commands.CommandFactory;
import com.sm.storemanagerfx.commands.CommandFactory.CommandType;
import com.sm.storemanagerfx.dao.CustomerDAO;
import com.sm.storemanagerfx.dao.CustomerDAO.CustomerNotFoundException;
import com.sm.storemanagerfx.entity.Customer;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Sven
 */
public class RemoveEntityCommandTest {
    
    private CustomerDAO customerDAO;
    private CommandFactory commandFactory;
    private Customer customer;
    
    @Before
    public void setUp() {
        this.customerDAO = new CustomerDAO();
        this.commandFactory =  CommandFactory.createInstance(customerDAO);
        this.customer = new Customer();
        BaseCommand command = commandFactory.createCustomerCommand(CommandType.ADD, customer);
        command.execute();
    }
    
    @Test(expected = CustomerNotFoundException.class)
    public void givenID_shouldRemoveFromDAO() {
        Customer c = new Customer();
        c.setId(1);
        BaseCommand command = commandFactory.createCustomerCommand(CommandType.REMOVE, c);
        command.execute();
        customerDAO.findCustomerById(1);
    }
}
