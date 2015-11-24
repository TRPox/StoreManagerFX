/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import com.sm.storemanagerfx.commands.BaseCommand;
import com.sm.storemanagerfx.commands.CommandFactory.EntityType;
import com.sm.storemanagerfx.entity.Customer;
import com.sm.storemanagerfx.util.EntityMapper;
import java.util.HashMap;
import java.util.Map;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.junit.MatcherAssert.assertThat;
import org.junit.Test;

/**
 *
 * @author Sven
 */
public class AddCustomerCommandTest extends CustomerCommandTest {
 
    @Test
    public void callingExectute_shouldAddToDAO() {
        Map<String, Object> dataMap = new HashMap();
        dataMap.put("id", 1);
        dataMap.put("firstName", "validFirstName");
        Customer c = EntityMapper.createCustomerFromMap(dataMap);
        BaseCommand addCustomerCommand = commandFactory.createAddCommand(EntityType.CUSTOMER , dataMap);
        addCustomerCommand.execute();
        assertThat(customerDAO.findCustomerById(1).getFirstName(), equalTo("validFirstName"));
    }
}
