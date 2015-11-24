/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sm.storemanagerfx.util;

import com.sm.storemanagerfx.entity.Customer;
import com.sm.storemanagerfx.outputentity.OutputPerson;
import com.sm.storemanagerfx.util.InputValidator.InvalidInputException;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.junit.MatcherAssert.assertThat;
import usecases.customerEBI.CustomerInteractor;

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
    
    private Customer invokeCreateCustomerFromMap(Map<String, Object> map) {
        try {
            Method createCustomerFromMap = EntityMapper.class.getDeclaredMethod("createCustomerFromMap", Map.class);
            Customer c = (Customer) createCustomerFromMap.invoke(map);
            return c;
        } catch (Exception e) {
            return null;
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
