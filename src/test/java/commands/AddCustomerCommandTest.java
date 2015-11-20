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
import com.sm.storemanagerfx.entity.Customer;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.junit.MatcherAssert.assertThat;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Sven
 */
public class AddCustomerCommandTest {
 
    private CustomerDAO customerDAO;
    private CommandFactory commandFactory;
    
    @Before
    public void setUp() {
        customerDAO = new CustomerDAO();
        commandFactory = new CommandFactory(customerDAO);
    }
    
    @Test
    public void callingExectute_shouldAddToDAO() {
        Customer c = new Customer();
        BaseCommand addCustomerCommand = commandFactory.createCommand(CommandType.ADD, c);
        addCustomerCommand.execute();
        assertThat(customerDAO.findCustomerById(1), equalTo(c));
    }
}
