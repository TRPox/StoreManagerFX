/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import com.sm.storemanagerfx.commands.AddCustomerCommand;
import com.sm.storemanagerfx.commands.BaseCommand;
import com.sm.storemanagerfx.commands.CommandFactory;
import com.sm.storemanagerfx.commands.CommandFactory.CommandType;
import com.sm.storemanagerfx.commands.RemoveCustomerCommand;
import com.sm.storemanagerfx.dao.CustomerDAO;
import com.sm.storemanagerfx.entity.Customer;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.hamcrest.junit.MatcherAssert.assertThat;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Sven
 */
public class CommandFactoryTest {
    
    private CustomerDAO customerDAO;
    
    
    @Before
    public void setUp() {
        this.customerDAO = new CustomerDAO();
        CommandFactory.createInstance(customerDAO);
    }
    
    @Test
    public void givenADDCustomer_shouldReturnAddCustomerCommand() {
        BaseCommand command = CommandFactory.createCustomerCommand(CommandType.ADD, new Customer());
        assertThat(command, is(instanceOf(AddCustomerCommand.class)));
    }
    
    @Test
    public void givenREMOVECustomer_shouldReturnRemoveCustomerCommand() {
        Customer c = new Customer();
        c.setId(1);
        BaseCommand command = CommandFactory.createCustomerCommand(CommandType.REMOVE, c);
        assertThat(command, is(instanceOf(RemoveCustomerCommand.class)));
    }
    
    private Customer createValidCustomer() {
        Customer c = new Customer();
        c.setFirstName("validFirstName");
        c.setLastName("validLastName");
        return c;
    }
}
