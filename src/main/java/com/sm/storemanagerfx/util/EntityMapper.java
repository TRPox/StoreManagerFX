/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sm.storemanagerfx.util;

import com.sm.storemanagerfx.entity.Appointment;
import com.sm.storemanagerfx.entity.Customer;
import com.sm.storemanagerfx.outputentity.OutputAppointment;
import com.sm.storemanagerfx.outputentity.OutputCustomer;
import static com.sm.storemanagerfx.util.InputValidator.isValid;

/**
 *
 * @author Sven
 */
public class EntityMapper {

    public static Customer mapToCustomer(OutputCustomer oc) {
        if (isValid(oc)) {
            Customer c = new Customer();
            c.setAddress(oc.getAddress());
            c.setBirthday(oc.getBirthday());
            c.setFirstName(oc.getFirstName());
            c.setId(oc.getId());
            c.setLastAppointment(mapToAppointment(oc.getLastAppointment()));
            c.setLastName(oc.getLastName());
            c.setNextAppointment(mapToAppointment(oc.getNextAppointment()));
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
}
