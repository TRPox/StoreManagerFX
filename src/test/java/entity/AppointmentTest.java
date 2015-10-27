/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import com.sm.storemanagerfx.entity.Appointment;
import java.time.LocalDateTime;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.junit.MatcherAssert.assertThat;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Sven
 */
public class AppointmentTest {

    private Appointment appointment;
    
    @Before
    public void setUp() {
        LocalDateTime startTime = LocalDateTime.of(2015, 9, 18, 14, 0);
        LocalDateTime endTime = LocalDateTime.of(2015, 9, 18, 15, 0);
        appointment = createAppointmentWithTime(startTime, endTime);
    }
    
    @Test
    public void givenNotCollidingAppointment_shouldReturnFalse() {
        Appointment notCollidingAppointment = createAppointmentWithTime(LocalDateTime.of(2015, 9, 18, 12, 0), LocalDateTime.of(2015, 9, 18, 13, 0));
        assertThat(appointment.collidesWith(notCollidingAppointment), equalTo(false));
    }
    
    @Test
    public void givenAppointmentWithSameStartTime_shouldReturnTrue() {
        Appointment collidingAppointment = createAppointmentWithTime(LocalDateTime.of(2015, 9, 18, 14, 0), LocalDateTime.of(2015, 9, 18, 16, 0));
        assertThat(appointment.collidesWith(collidingAppointment), equalTo(true));
    }
    
    @Test
    public void givenAppointmentWithSameEndTime_shouldReturnTrue() {
        Appointment collidingAppointment = createAppointmentWithTime(LocalDateTime.of(2015, 9, 18, 12, 0), LocalDateTime.of(2015, 9, 18, 15, 0));
        assertThat(appointment.collidesWith(collidingAppointment), equalTo(true));
    }
    
    @Test
    public void givenAppointmentWithCollidingStartTime_shouldReturnTrue() {
        Appointment collidingAppointment = createAppointmentWithTime(LocalDateTime.of(2015, 9, 18, 14, 20), LocalDateTime.of(2015, 9, 18, 16, 0));
        assertThat(appointment.collidesWith(collidingAppointment), equalTo(true));
    }
    
    @Test
    public void givenAppointmentWithCollidingEndTime_shouldReturnTrue() {
        Appointment collidingAppointment = createAppointmentWithTime(LocalDateTime.of(2015, 9, 18, 12, 0), LocalDateTime.of(2015, 9, 18, 14, 20));
        assertThat(appointment.collidesWith(collidingAppointment), equalTo(true));
    }
    
    private Appointment createAppointmentWithTime(LocalDateTime startTime, LocalDateTime endTime) {
        Appointment newAppointment = new Appointment();
        newAppointment.setStartTime(startTime);
        newAppointment.setEndTime(endTime);
        return newAppointment;
    }
}
