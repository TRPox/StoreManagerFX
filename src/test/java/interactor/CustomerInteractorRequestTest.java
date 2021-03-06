/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interactor;

import com.sm.storemanagerfx.commands.CommandFactory;
import com.sm.storemanagerfx.dao.CustomerDAO;
import com.sm.storemanagerfx.util.InputValidator.InvalidInputException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.junit.MatcherAssert.assertThat;
import org.junit.Before;
import org.junit.Test;
import usecases.customerEBI.CustomerInteractor;

/**
 *
 * @author Sven
 */
public class CustomerInteractorRequestTest {

    private CustomerInteractor ci;
    private CustomerDAO customerDAO;
    

    @Before
    public void setUp() {
        customerDAO = new CustomerDAO();
        ci = new CustomerInteractor(customerDAO, new CommandFactory(customerDAO));
    }

    @Test(expected = InvalidInputException.class)
    public void givenNull_ShouldThrowInvalidInputException() {
        ci.addCustomer(null);
    }

    @Test
    public void givenValidDataMapToAdd_shouldAddToDAO() {
            Map<String, Object> map = createValidMap();
            ci.addCustomer(map);
            assertThat(customerDAO.findCustomerById(1).getFirstName(), equalTo("validFirstName"));
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
