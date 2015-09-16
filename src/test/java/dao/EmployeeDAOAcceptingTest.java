/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.sm.storemanagerfx.entity.Customer;
import com.sm.storemanagerfx.entity.Employee;
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
public class EmployeeDAOAcceptingTest extends EmployeeDAOTest {
    
    private Employee employee;
    
    @Before
    public void addCustomerToDAO() {
        employee = createValidEmployee();
        dao.getEmployeeList().add(employee);
    }
    
    @Test
    public void givenValidInput_shouldReturnList() {
        assertThat(dao.findEmployeesByName("valid", "valid"), instanceOf(List.class));
    }
    
    @Test
    public void givenValidInputWithNoMatch_shouldReturnEmptyList() {
        assertThat(dao.findEmployeesByName("validNoMatch", "validNoMatch").size(), equalTo(0));
    }
    
    @Test
    public void givenValidInput_shouldReturnListWithMatches() {
        Employee foundEmployee = dao.findEmployeesByName("validFirstName", "validLastName").get(0);
        assertThat(foundEmployee, equalTo(employee));
    }
    
    @Test
    public void givenValidId_shouldReturnCustomer() {
        assertThat(dao.findEmployeeById(0), equalTo(employee));
    }
    
    private Employee createValidEmployee() {
        employee = new Employee();
        employee.setFirstName("validFirstName");
        employee.setLastName("validLastName");
        employee.setId(0);
        return employee;
    }
}
