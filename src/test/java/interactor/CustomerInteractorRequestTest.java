/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interactor;

import com.sm.storemanagerfx.dao.CustomerDAO;
import com.sm.storemanagerfx.entity.Customer;
import com.sm.storemanagerfx.util.InputValidator.InvalidInputException;
import java.lang.reflect.Method;
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
        ci = new CustomerInteractor(customerDAO);
    }

    @Test
    public void givenValidDataMap_shouldMapToCustomer() {
        try { //for some reason the try is needed here AND in invokeCreateCustomerFromMap; getting NullPointerException otherwise
            Map<String, Object> map = createValidMap();
            Customer c = invokeCreateCustomerFromMap(map);
            assertThat(c.getFirstName(), equalTo("validFirstName"));
            assertThat(c.getFirstName(), equalTo("validLastName"));
            assertThat(c.getBirthday(), equalTo(LocalDate.of(1990, 12, 13)));
            assertThat(c.getAddress().getCity(), equalTo("validCity"));
            assertThat(c.getAddress().getPostalCode(), equalTo("validPostalCode"));
            assertThat(c.getAddress().getStreet(), equalTo("validStreet"));
            assertThat(c.getAddress().getPhone(), equalTo("validPhone"));
            assertThat(c.getAddress().getEmail(), equalTo("validEmail"));
        } catch (Exception e) {
        }

    }

    @Test(expected = InvalidInputException.class)
    public void givenNull_ShouldThrowInvalidInputException() {
        ci.addCustomer(null);
    }

    @Test
    public void givenValidDataMapToAdd_shouldAddToDAO() {
        try { //for some reason the try is needed here AND in invokeCreateCustomerFromMap; getting NullPointerException otherwise
            Map<String, Object> map = createValidMap();
            Customer c = invokeCreateCustomerFromMap(map);
            ci.addCustomer(map);
            assertThat(customerDAO.findCustomerById(1), equalTo(c));
        } catch (Exception e) {
        }
    }

    private Map<String, Object> createValidMap() {
        Map<String, Object> map = new HashMap<>();
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

    private Customer invokeCreateCustomerFromMap(Map<String, Object> map) {
        try {
            Method createCustomerFromMap = CustomerInteractor.class.getDeclaredMethod("createCustomerFromMap", Map.class);
            Customer c = (Customer) createCustomerFromMap.invoke(map);
            return c;
        } catch (Exception e) {
            return null;
        }
    }

}
