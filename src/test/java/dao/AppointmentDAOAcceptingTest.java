/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.sm.storemanagerfx.entity.Appointment;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
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
        dao.getAppointmentList().add(appointment);
    }

    
    @Test
    public void givenValidDate_shouldReturnList() {
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
    
    private Appointment createValidAppointment() {
        Appointment a = new Appointment();
        a.setStartTime(LocalDateTime.of(2015, 9, 16, 14, 0));
        a.setEndTime(LocalDateTime.of(2015, 9, 16, 15, 0));
        return a;
    }
}
