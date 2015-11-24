/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import com.sm.storemanagerfx.commands.AddCustomerCommand;
import com.sm.storemanagerfx.commands.BaseCommand;
import com.sm.storemanagerfx.commands.CommandFactory;
import com.sm.storemanagerfx.commands.CommandFactory.EntityType;
import com.sm.storemanagerfx.commands.EditCustomerCommand;
import com.sm.storemanagerfx.commands.RemoveCustomerCommand;
import com.sm.storemanagerfx.dao.CustomerDAO;
import com.sm.storemanagerfx.entity.Customer;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
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
    private CommandFactory commandFactory;
    
    
    @Before
    public void setUp() {
        this.customerDAO = new CustomerDAO();
        this.commandFactory = new CommandFactory(customerDAO);
    }
    
    @Test
    public void givenADDCustomer_shouldReturnAddCustomerCommand() {
        BaseCommand command = commandFactory.createAddCommand(EntityType.CUSTOMER, createValidMap());
        assertThat(command, is(instanceOf(AddCustomerCommand.class)));
    }
    
    @Test
    public void givenEDITCustomer_shouldReturnEditCustomerCommand() {
        BaseCommand command = commandFactory.createEditCommand(EntityType.CUSTOMER, createValidMap());
        assertThat(command, is(instanceOf(EditCustomerCommand.class)));
    }
    
    @Test
    public void givenREMOVECustomer_shouldReturnRemoveCustomerCommand() {
        Customer c = new Customer();
        c.setId(1);
        BaseCommand command = commandFactory.createRemoveCommand(EntityType.CUSTOMER, createValidMap());
        assertThat(command, is(instanceOf(RemoveCustomerCommand.class)));
    }
    
    private Map<String, Object> createValidMap() {
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
