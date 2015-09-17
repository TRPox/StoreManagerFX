/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.sm.storemanagerfx.entity.Appointment;
import com.sm.storemanagerfx.entity.Customer;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
public class AppointmentDAOAcceptingTest extends AppointmentDAOTest {
    
    private Appointment appointment;
    
    @Before
    public void addAppointmentToDAO() {
        appointment = createValidAppointment();
        dao.add(appointment);
    }

    
    @Test
    public void givenValidDate_shouldReturnList() {
        System.out.println(LocalDate.now().getClass().getCanonicalName());
        assertThat(dao.findAppointmentsByDate(LocalDate.MIN), instanceOf(List.class));
    }
    
    @Test
    public void givenValidDateWithNoMatches_shouldReturnEmptyList() {
        assertThat(dao.findAppointmentsByDate(LocalDate.MIN).size(), equalTo(0));
    }
    
    @Test
    public void givenValidDate_shouldReturnListWithMatches() {
        List<Appointment> matches = dao.findAppointmentsByDate(LocalDate.of(2015, 9, 16));
        assertThat(matches.get(0), equalTo(appointment));
    }
    
    @Test
    public void givenValidCustomer_shouldReturnList() {
        assertThat(dao.findAppointmentsByCustomer(new Customer()), instanceOf(List.class));
    }
    
    @Test
    public void givenValidCustomerWithNoMatches_shouldReturnEmptyList() {
        assertThat(dao.findAppointmentsByCustomer(new Customer()).size(), equalTo(0));
    }
    
    @Test
    public void givenValidCustomer_shouldReturnListWithMatches() {
        Customer customer = appointment.getCustomer();
        Appointment foundAppointment = dao.findAppointmentsByCustomer(customer).get(0);
        assertThat(foundAppointment, equalTo(appointment));
    }
    
    private Appointment createValidAppointment() {
        Appointment a = new Appointment();
        a.setStartTime(LocalDateTime.of(2015, 9, 16, 14, 0));
        a.setEndTime(LocalDateTime.of(2015, 9, 16, 15, 0));
        Customer customer = createValidCustomer();
        a.setCustomer(customer);
        return a;
    }

    private Customer createValidCustomer() {
        Customer customer = new Customer();
        customer.setFirstName("Valid");
        customer.setLastName("Valid");
        return customer;
    }
}
