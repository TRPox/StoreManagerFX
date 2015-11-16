/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sm.storemanagerfx.util;

import com.sm.storemanagerfx.entity.Customer;
import com.sm.storemanagerfx.outputentity.OutputPerson;
import com.sm.storemanagerfx.util.InputValidator.InvalidInputException;
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
    public void givenOutputPerson_shouldReturnCustomer() {
        OutputPerson oc = createOutputPerson();
        assertThat(EntityMapper.mapToCustomer(oc), is(instanceOf(Customer.class)));
    }

    @Test
    public void givenOutputPerson_shouldMapToEqualCustomer() {
        OutputPerson oc = createOutputPerson();
        Customer c = EntityMapper.mapToCustomer(oc);
        assertThat(c.getFirstName(), equalTo(oc.getFirstName()));
        assertThat(c.getLastName(), equalTo(oc.getLastName()));
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

    private OutputPerson createOutputPerson() {
        OutputPerson oc = new OutputPerson();
        oc.setFirstName("First");
        oc.setLastName("Last");
        oc.setId(1);
        return oc;
    }
    
}
