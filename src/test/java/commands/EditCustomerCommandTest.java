/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import com.sm.storemanagerfx.commands.BaseCommand;
import com.sm.storemanagerfx.commands.CommandFactory.EntityType;
import java.util.HashMap;
import java.util.Map;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.junit.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author marcus
 */
public class EditCustomerCommandTest extends CustomerCommandTest {

    @Before
    public void addCustomerToDAO() {
        BaseCommand command = commandFactory.createAddCommand(EntityType.CUSTOMER, createValidMap());
        command.execute();
    }

    @Test
    public void givenCustomer_ShouldEditCustomerWithSameId() {
        Map<String, Object> dataMap = new HashMap();
        dataMap.put("id", 1);
        dataMap.put("firstName", "newName");
        BaseCommand command = commandFactory.createEditCommand(EntityType.CUSTOMER, dataMap);
        command.execute();
        assertThat(customerDAO.findCustomerById(1).getFirstName(), equalTo("newName"));
    }

    
//    public enum DataType {
//        INT(Integer.class),
//        DOUBLE(Double.class),
//        STRING(String.class),
//        BOOLEAN(Boolean.class);
//        private Class c;
//        DataType(Class c) {
//            this.c = c;
//        }
//        
//        public DataType find(Class c) {
//            
//            for(DataType d : values()) {
//                if(d.c.equals(c)) {
//                    return d;
//                }
//            }
//            return null;
//        }
//        
//    }
    
}
