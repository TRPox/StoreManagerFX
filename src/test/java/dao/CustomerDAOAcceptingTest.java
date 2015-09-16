/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.sm.storemanagerfx.entity.Customer;
import java.util.List;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.hamcrest.junit.MatcherAssert.assertThat;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Sven
 */
public class CustomerDAOAcceptingTest extends CustomerDAOTest {
    
    private Customer customer;
    
    @Before
    public void addCustomerToDAO() {
        customer = createValidCustomer();
        dao.getCustomerList().add(customer);
    }
    
    @Test
    public void givenValidInput_shouldReturnList() {
        assertThat(dao.findCustomersByName("valid", "valid"), instanceOf(List.class));
    }
    
    @Test
    public void givenValidInputWithNoMatch_shouldReturnEmptyList() {
        assertThat(dao.findCustomersByName("validNoMatch", "validNoMatch").size(), equalTo(0));
    }
    
    @Test
    public void givenValidInput_shouldReturnListWithMatches() {
        Customer foundCustomer = dao.findCustomersByName("validFirstName", "validLastName").get(0);
        assertThat(foundCustomer, equalTo(customer));
    }
    
    @Test
    public void givenValidId_shouldReturnCustomer() {
        assertThat(dao.findCustomerById(0), equalTo(customer));
    }
    
    private Customer createValidCustomer() {
        customer = new Customer();
        customer.setFirstName("validFirstName");
        customer.setLastName("validLastName");
        customer.setId(0);
        return customer;
    }
}
