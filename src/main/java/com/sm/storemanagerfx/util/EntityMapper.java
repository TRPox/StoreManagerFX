/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sm.storemanagerfx.util;

import com.sm.storemanagerfx.entity.Address;
import com.sm.storemanagerfx.entity.Appointment;
import com.sm.storemanagerfx.entity.Customer;
import com.sm.storemanagerfx.outputentity.OutputAppointment;
import com.sm.storemanagerfx.outputentity.OutputPerson;
import static com.sm.storemanagerfx.util.InputValidator.isValid;
import java.time.LocalDate;
import java.util.Map;

/**
 *
 * @author Sven
 */
public class EntityMapper {

    public static Customer mapToCustomer(OutputPerson oc) {
        if (isValid(oc)) {
            Customer c = new Customer();
            c.setFirstName(oc.getFirstName());
            c.setId(oc.getId());
            c.setLastName(oc.getLastName());
            return c;
        }
        return null;
    }

    public static Appointment mapToAppointment(OutputAppointment oa) {
        if (isValid(oa)) {
            Appointment a = new Appointment();
            return a;
        }
        return null;
    }
    
    public static Customer createCustomerFromMap(Map<String, Object> dataMap) {
        Customer c = new Customer();
        c.setId((int) dataMap.get("id"));
        c.setFirstName((String) dataMap.get("firstName"));
        c.setLastName((String) dataMap.get("lastName"));
        c.setBirthday((LocalDate) dataMap.get("birthday"));
        c.setAddress(createAddressFromMap(dataMap));
        return c;
    }

    public static Address createAddressFromMap(Map<String, Object> dataMap) {
        Address address = new Address();
        address.setCity((String) dataMap.get("city"));
        address.setEmail((String) dataMap.get("email"));
        address.setPhone((String) dataMap.get("phone"));
        address.setPostalCode((String) dataMap.get("postalCode"));
        address.setStreet((String) dataMap.get("street"));
        return address;
    }
}
