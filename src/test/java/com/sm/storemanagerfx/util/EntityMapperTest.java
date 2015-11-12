/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sm.storemanagerfx.util;

import com.sm.storemanagerfx.entity.Address;
import com.sm.storemanagerfx.entity.Customer;
import com.sm.storemanagerfx.outputentity.OutputAppointment;
import com.sm.storemanagerfx.outputentity.OutputCustomer;
import com.sm.storemanagerfx.util.InputValidator.InvalidInputException;
import java.time.LocalDate;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sven
 */
public class EntityMapperTest {
    
    
    @Before
    public void setUp() {
        
    }
    
    @Test(expected = InvalidInputException.class)
    public void givenNull_shouldThrowInvalidInputException() {
        EntityMapper.mapToCustomer(null);
    }
    
    @Test
    public void givenOutputCustomer_shouldReturnCustomer() {
        OutputCustomer oc = createOutputCustomer();
        assertThat(EntityMapper.mapToCustomer(oc), is(instanceOf(Customer.class)));
    }

    @Test
    public void givenOutputCustomer_shouldMapToEqualCustomer() {
        OutputCustomer oc = createOutputCustomer();
        Customer c = EntityMapper.mapToCustomer(oc);
        assertThat(c.getFirstName(), equalTo(oc.getFirstName()));
        assertThat(c.getLastName(), equalTo(oc.getLastName()));
        assertThat(c.getBirthday(), equalTo(oc.getBirthday()));
        assertThat(c.getId(), equalTo(oc.getId()));
    }
    
//    @Test
//    public void testMapToAppointment() {
//        System.out.println("mapToAppointment");
//        OutputAppointment oa = null;
//        Appointment expResult = null;
//        Appointment result = EntityMapper.mapToAppointment(oa);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    private OutputCustomer createOutputCustomer() {
        OutputCustomer oc = new OutputCustomer();
        oc.setFirstName("First");
        oc.setLastName("Last");
        oc.setBirthday(LocalDate.of(2015, 1, 1));
        oc.setId(1);
        oc.setAddress(new Address());
        oc.setNextAppointment(new OutputAppointment());
        oc.setLastAppointment(new OutputAppointment());
        return oc;
    }
    
}
